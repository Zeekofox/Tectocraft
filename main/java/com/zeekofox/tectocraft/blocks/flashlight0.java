package com.zeekofox.tectocraft.blocks;

import java.util.ArrayList;
import java.util.Random;

import com.zeekofox.tectocraft.Tectocraft;
import com.zeekofox.tectocraft.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Flashlight0 extends BlockAir{
	
	public Flashlight0(Material material) {
		super();
		this.setLightLevel(1F);
		this.setTickRandomly(true);
	}
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
    }
    public int tickRate(World worldIn)
    {
        return 1;
    }
}
