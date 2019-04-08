package com.zeekofox.tectocraft.items.tools;

import java.util.Set;

import com.zeekofox.tectocraft.Tectocraft;
import com.zeekofox.tectocraft.init.ModItems;
import com.zeekofox.tectocraft.utils.IHasModel;

import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel{
	
	public ToolSword(String name, ToolMaterial material) {
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
