package com.zeekofox.tectocraft.items;

import com.zeekofox.tectocraft.Tectocraft;
import com.zeekofox.tectocraft.init.ModItems;
import com.zeekofox.tectocraft.utils.IHasModel;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Tectocraft.tabTectocraft);
		ModItems.ITEMS.add(this);
	}
	@Override
	public void registerModels() {
		Tectocraft.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
