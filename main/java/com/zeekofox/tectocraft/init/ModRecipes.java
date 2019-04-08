package com.zeekofox.tectocraft.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.TUNGSTEN_ORE_WORLD, new ItemStack(ModItems.TUNGSTEN_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TUNGSTEN_ORE_END, new ItemStack(ModItems.TUNGSTEN_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TUNGSTEN_ORE_NETHER, new ItemStack(ModItems.TUNGSTEN_INGOT, 1), 1.0F);
	}
}
