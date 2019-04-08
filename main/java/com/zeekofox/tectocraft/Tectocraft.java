package com.zeekofox.tectocraft;


import org.apache.logging.log4j.Logger;

import com.zeekofox.tectocraft.init.ModItems;
import com.zeekofox.tectocraft.init.ModRecipes;
import com.zeekofox.tectocraft.proxy.CommonProxy;
import com.zeekofox.tectocraft.utils.Reference;
import com.zeekofox.tectocraft.world.ModWorldGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=Reference.MODID, name= Reference.NAME, version=Reference.VERSION)
public class Tectocraft {
	   @Instance
	   public static Tectocraft instance;
	   @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	   public static CommonProxy proxy;
	   public static Logger logger;
	   public static CreativeTabs tabTectocraft = new CreativeTabs("tectocraft")
		{
			public ItemStack getTabIconItem()
			{
				return ModItems.TECTONIUM_INGOT.getDefaultInstance();
			}
		};
	   @EventHandler
	   public static void preInit(FMLPreInitializationEvent event) {
		   proxy.preInit(event);
		   logger = event.getModLog();
	   }
	   @EventHandler
	   public static void init(FMLInitializationEvent event) {
		   proxy.init(event);
		   ModRecipes.init();
		   GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
	   }
	   @EventHandler
	   public static void postInit(FMLPostInitializationEvent event) {
		   proxy.postInit(event);
	   }
}
