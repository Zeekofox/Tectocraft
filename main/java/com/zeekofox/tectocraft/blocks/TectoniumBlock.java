package com.zeekofox.tectocraft.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TectoniumBlock extends BlockBase {

	public TectoniumBlock(String name, Material materialIn) {
		super(name, materialIn);
		this.setHardness(3F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(3F);
		this.setSoundType(SoundType.METAL);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			tooltip.add("Something special");
			tooltip.add("Infused with elements out of this world");
		}else{
			tooltip.add(TextFormatting.ITALIC+"Press " + TextFormatting.YELLOW+ "SHIFT" +TextFormatting.GRAY + TextFormatting.ITALIC+" for information");
		}
	}
	 @SideOnly(Side.CLIENT)
	    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	    {
	      if ((rand.nextInt(2) == 0)) {
	    	  worldIn.spawnParticle(
						EnumParticleTypes.SPELL_WITCH,
						pos.getX() + rand.nextDouble(),
						pos.getY() + 1.01,
						pos.getZ() + rand.nextDouble(),
						0.0D, 0.0D, 0.0D);
	      		}
	   }
}
