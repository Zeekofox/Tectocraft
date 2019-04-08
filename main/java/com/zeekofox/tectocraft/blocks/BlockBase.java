package com.zeekofox.tectocraft.blocks;

import com.zeekofox.tectocraft.Tectocraft;
import com.zeekofox.tectocraft.init.ModBlocks;
import com.zeekofox.tectocraft.init.ModItems;
import com.zeekofox.tectocraft.utils.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel{

	public BlockBase(String name, Material materialIn) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Tectocraft.tabTectocraft);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Tectocraft.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
