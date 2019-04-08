package com.zeekofox.tectocraft.items;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.Maps;
import com.zeekofox.tectocraft.init.ModBlocks;
import com.zeekofox.tectocraft.utils.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FlashLight extends ItemBase implements IHasModel{
	public FlashLight(String name) {
		super(name);
		this.setMaxStackSize(1);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			tooltip.add("Reveals the beauty of the world");
			tooltip.add("Eternal darkness no more");
			if(stack.getItemDamage() == 1)
			tooltip.add(TextFormatting.GREEN + "On");
			else if(stack.getItemDamage() == 0)
				tooltip.add(TextFormatting.GREEN + "Off");
		}else{
			tooltip.add(TextFormatting.ITALIC+"Press " + TextFormatting.YELLOW+ "SHIFT" +TextFormatting.GRAY + TextFormatting.ITALIC+" for information");
		}
	}
	@Override
	 public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
   {
		if(!worldIn.isRemote && stack.getItemDamage() != 0) {
		int x = (int) Math.floor(entityIn.posX);
		int y = (int) entityIn.posY + 1;
		int z = (int) Math.floor(entityIn.posZ);
		BlockPos pos = new BlockPos(entityIn.getPosition());
		if(stack.getItemDamage() == 0 && (worldIn.getBlockState(pos).getBlock() == Blocks.AIR && !worldIn.isRemote)){
			worldIn.setBlockState(pos, ModBlocks.FLASHLIGHT0.getDefaultState());
			}
		}
	}
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	    {
		 	ItemStack stack = playerIn.getHeldItemMainhand();
			if(stack.getItemDamage() == 0) {
				stack.setItemDamage(1);
			}
			else {
				stack.setItemDamage(0);
			}
			return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
		 
	    }
}
