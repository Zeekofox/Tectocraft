package com.zeekofox.tectocraft.items.tools;

import com.zeekofox.tectocraft.Tectocraft;
import com.zeekofox.tectocraft.init.ModItems;
import com.zeekofox.tectocraft.utils.IHasModel;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;

public class ToolAxe extends ItemAxe implements IHasModel{
	
	public ToolAxe(String name, ToolMaterial material) {
		super(material, 6.0F, -3.2F);
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