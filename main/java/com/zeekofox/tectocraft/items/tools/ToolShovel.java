package com.zeekofox.tectocraft.items.tools;

import com.zeekofox.tectocraft.Tectocraft;
import com.zeekofox.tectocraft.init.ModItems;
import com.zeekofox.tectocraft.utils.IHasModel;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;

public class ToolShovel extends ItemSpade implements IHasModel{
	
	public ToolShovel(String name, ToolMaterial material) {
		super(material);
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
