package com.zeekofox.tectocraft.blocks;

import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import com.zeekofox.tectocraft.utils.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TungstenBlock extends BlockBase implements IHasModel{

	public TungstenBlock(String name, Material materialIn) {
		super(name, materialIn);
		this.setHardness(4F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5F);
		this.setSoundType(SoundType.METAL);
	}
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				tooltip.add("Excellent for high temperature operations");
			}else{
				tooltip.add(TextFormatting.ITALIC+"Press " + TextFormatting.YELLOW+ "SHIFT" +TextFormatting.GRAY + TextFormatting.ITALIC+" for information");
			}
		}
}
