package com.zeekofox.tectocraft.items.tools;

import com.zeekofox.tectocraft.Tectocraft;
import com.zeekofox.tectocraft.init.ModItems;
import com.zeekofox.tectocraft.utils.IHasModel;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements IHasModel{

	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
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
