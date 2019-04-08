package com.zeekofox.tectocraft.init;

import java.util.ArrayList;
import java.util.List;

import com.zeekofox.tectocraft.blocks.BlockBase;
import com.zeekofox.tectocraft.blocks.TectoniumBlock;
import com.zeekofox.tectocraft.blocks.TungstenBlock;
import com.zeekofox.tectocraft.blocks.TungstenOreEnd;
import com.zeekofox.tectocraft.blocks.TungstenOreNether;
import com.zeekofox.tectocraft.blocks.TungstenOreWorld;
import com.zeekofox.tectocraft.blocks.flashlight0;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final Block TECTONIUM_BLOCK = new TectoniumBlock("tectonium_block", Material.IRON);
	public static final Block TUNGSTEN_BLOCK = new TungstenBlock("tungsten_block", Material.IRON);
	public static final Block TUNGSTEN_ORE_WORLD = new TungstenOreWorld("tungsten_ore_world", Material.ROCK);
	public static final Block TUNGSTEN_ORE_NETHER = new TungstenOreNether("tungsten_ore_nether", Material.ROCK);
	public static final Block TUNGSTEN_ORE_END = new TungstenOreEnd("tungsten_ore_end", Material.ROCK);
	public static final Block FLASHLIGHT0 = new flashlight0(Material.AIR);
}
