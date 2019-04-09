package com.zeekofox.tectocraft.items;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.Maps;
import com.zeekofox.tectocraft.Tectocraft;
import com.zeekofox.tectocraft.init.ModBlocks;
import com.zeekofox.tectocraft.items.FlashLight.SubItemPropertyGetter;
import com.zeekofox.tectocraft.proxy.ClientProxy;
import com.zeekofox.tectocraft.utils.IHasModel;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.collection.generic.BitOperations.Int;

public class FlashLight1 extends ItemBase implements IHasModel{

	public FlashLight1(String name) {
		super(name);
		setMaxStackSize(1);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.addPropertyOverride(new ResourceLocation("state"), new SubItemPropertyGetter());
	}
	public class SubItemPropertyGetter implements IItemPropertyGetter{
	    @Override
	    public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
	    	return stack.getItemDamage();
	    }
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			tooltip.add("Reveals the beauty of the world");
			tooltip.add("Eternal darkness no more");
//			if(stack.hasTagCompound() && stack.getTagCompound().hasKey("state") && stack.getTagCompound().getInteger("state") == 1)
			if(stack.getItemDamage() == 1)
			tooltip.add(TextFormatting.GREEN + "On");
			else
//			else if(stack.hasTagCompound() && stack.getTagCompound().hasKey("state") && stack.getTagCompound().getInteger("state") == 0)
				tooltip.add(TextFormatting.GREEN + "Off");
		}else{
			tooltip.add(TextFormatting.ITALIC+"Press " + TextFormatting.YELLOW+ "SHIFT" +TextFormatting.GRAY + TextFormatting.ITALIC+" for information");
		}
	}
	@Override
	 public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
//		if(stack.hasTagCompound() && stack.getTagCompound().getInteger("state") == 1) {
		if(stack.getItemDamage() == 1) {
		int x = (int) Math.floor(entityIn.posX);
		int y = (int) entityIn.posY + 1;
		int z = (int) Math.floor(entityIn.posZ);
		BlockPos pos = new BlockPos(entityIn.getPosition());
		if(worldIn.getBlockState(pos).getBlock() == Blocks.AIR && !worldIn.isRemote){
			worldIn.setBlockState(pos, ModBlocks.FLASHLIGHT0.getDefaultState());
			}
		}
	}
	  public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	    {
//		  	ItemStack stack = playerIn.getHeldItemMainhand();
//		  	NBTTagCompound nbt;
//		    if (stack.hasTagCompound())
//		    {
//		        nbt = stack.getTagCompound();
//		    }
//		    else
//		    {
//		        nbt = new NBTTagCompound();
//		        nbt.setInteger("state", 1);
//		    }
//		    if (nbt.hasKey("state") && Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) && nbt.getInteger("state") == 0)
//		    {
//		        nbt.setInteger("state", 1);
//		    }
//		    else if(nbt.hasKey("state") && Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) && nbt.getInteger("state") == 1)
//		    {
//		        nbt.setInteger("state", 0);
//		    }
//		    stack.setTagCompound(nbt);
		  	ItemStack stack = playerIn.getHeldItemMainhand();
		  	SubItemPropertyGetter sipg = new SubItemPropertyGetter();
		  	switch(stack.getItemDamage()) {
		  	case 0:
		  		stack.setItemDamage(1);
		  		break;
		  	case 1:
		  		stack.setItemDamage(0);
		  		break;
		  	}

	  		sipg.apply(stack, worldIn, playerIn);
			return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
	    }
}
