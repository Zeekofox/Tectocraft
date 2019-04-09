package com.zeekofox.tectocraft.items;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import com.zeekofox.tectocraft.utils.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MegaMagnet extends ItemBase implements IHasModel{
	
	private double range = 20.0D;
	
	public MegaMagnet(String name) {
		super(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			tooltip.add("Sucks items in a " + Math.round(range) + " block range..");
		}else{
			tooltip.add(TextFormatting.ITALIC+"Press " + TextFormatting.YELLOW+ "SHIFT" +TextFormatting.GRAY + TextFormatting.ITALIC+" for information");
		}
	}
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return stack.getItemDamage() == 1 ? true : false;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
	@Override
	public void onUpdate(ItemStack ist, World world, Entity e, int i, boolean f) {
		if (ist.getItemDamage() == 0) return;
		EntityPlayer player = null;
		if (e instanceof EntityPlayer) {
			player = (EntityPlayer)e;
		}
		if (player == null) return;
		scanForEntitiesInRange(world, player, range);
	}

	private void scanForEntitiesInRange(World world, EntityPlayer player, double d) {
		List iList = world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(player.posX - d, player.posY - d, player.posZ - d, player.posX + d, player.posY + d, player.posZ + d));
		Iterator iterator = iList.iterator();
		while (iterator.hasNext()) {
			EntityItem item = (EntityItem)iterator.next();
			if (!checkForRoom(item.getEntityItem(), player)) {
				continue;
			}
			if (item.delayBeforeCanPickup > 0) {
				item.delayBeforeCanPickup = 0;
			}
			if (player.getDistance(item) < 1.5D) {
				continue;
			}
			teleportEntityToPlayer(item, player);
			break;
		}
		List iList2 = world.getEntitiesWithinAABB(EntityXPOrb.class, AxisAlignedBB.getBoundingBox(player.posX - d, player.posY - d, player.posZ - d, player.posX + d, player.posY + d, player.posZ + d));
		Iterator iterator2 = iList2.iterator();
		while (iterator2.hasNext()) {
			EntityXPOrb item = (EntityXPOrb)iterator2.next();
			if (player.xpCooldown > 0) {
				player.xpCooldown = 0;
			}
			if (player.getDistance(item) < 1.5D) {
				continue;
			}
			teleportEntityToPlayer(item, player);
			break;
		}
	}

	private void teleportEntityToPlayer(Entity item, EntityPlayer player) {
		player.getLookVec();
		double x = player.posX + player.getLookVec().x * 0.2D;
		double y = player.posY - player.height / 2F;
		double z = player.posZ + player.getLookVec().z * 0.2D;
		item.setPosition(x, y, z);
	}

	private boolean checkForRoom(ItemStack stack, EntityPlayer player) {
		int remaining = stack.getMaxStackSize();
		for (ItemStack ist : player.inventory.mainInventory) {
			if (ist == null) {
				continue;
			}
			if (ist.getItem() == stack.getItem() && ist.getItemDamage() == stack.getItemDamage()) {
				if (ist.getMaxStackSize() + remaining <= ist.getMaxStackSize()) return true;
				else {
					int count = ist.getMaxStackSize();
					while (count < ist.getMaxStackSize()) {
						count++;
						remaining--;
						if (remaining == 0) return true;
					}
				}
			}
		}
		for (int slot = 0; slot < player.inventory.mainInventory.length; slot++) {
			if (player.inventory.mainInventory[slot] == null) return true;
		}
		return false;
	}

	@Override
	public void onUsingItemTick(ItemStack ist, EntityPlayer player, int count) {
		if (ist.getItemDamage() == 0) return;
		scanForEntitiesInRange(player.worldObj, player, 15.0D);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 64;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.BLOCK;
	}

	@Override 
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
		ItemStack stack = playerIn.getHeldItemMainhand();
		if (worldIn.isRemote) return ActionResult.newResult(EnumActionResult.SUCCESS,stack);
		if (playerIn.isSneaking()) {
			playerIn.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		} else {
			stack.setItemDamage(stack.getItemDamage() == 0 ? 1 : 0);
		}
		return ActionResult.newResult(EnumActionResult.SUCCESS,stack);
	}
}
}
