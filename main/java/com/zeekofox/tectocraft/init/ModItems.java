package com.zeekofox.tectocraft.init;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import com.zeekofox.tectocraft.items.PogoStick;
import com.zeekofox.tectocraft.items.FlashLight;
import com.zeekofox.tectocraft.items.FlashLight1;
import com.zeekofox.tectocraft.items.ItemBase;
import com.zeekofox.tectocraft.items.tools.ArmorBase;
import com.zeekofox.tectocraft.items.tools.ToolAxe;
import com.zeekofox.tectocraft.items.tools.ToolHoe;
import com.zeekofox.tectocraft.items.tools.ToolPickaxe;
import com.zeekofox.tectocraft.items.tools.ToolShovel;
import com.zeekofox.tectocraft.items.tools.ToolSword;
import com.zeekofox.tectocraft.utils.Reference;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	public static final ToolMaterial MATERIAL_TECTONIUM = EnumHelper.addToolMaterial("material_tectonium", 2, 560, 6.7F, 2.5F, 17);
	public static final ArmorMaterial ARMOR_MATERIAL_TECTONIUM = EnumHelper.addArmorMaterial("armor_material_tectonium", Reference.MODID+":tectonium", 12, new int[] {2, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final Item TECTONIUM_INGOT = new ItemBase("tectonium_ingot") {
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				tooltip.add("Something special");
				tooltip.add("Infused with elements out of this world");
			}else{
				tooltip.add(TextFormatting.ITALIC+"Press " + TextFormatting.YELLOW+ "SHIFT" +TextFormatting.GRAY + TextFormatting.ITALIC+" for information");
			}
		}
	};
	public static final Item TUNGSTEN_INGOT = new ItemBase("tungsten_ingot") {
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				tooltip.add("Excellent for high temperature operations");
			}else{
				tooltip.add(TextFormatting.ITALIC+"Press " + TextFormatting.YELLOW+ "SHIFT" +TextFormatting.GRAY + TextFormatting.ITALIC+" for information");
			}
		}
	};
	public static final Item TUNGSTEN_DUST = new ItemBase("tungsten_dust");
	public static final Item LED = new ItemBase("led") {
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				tooltip.add("Light Emitting Diode");
			}else{
				tooltip.add(TextFormatting.ITALIC+"Press " + TextFormatting.YELLOW+ "SHIFT" +TextFormatting.GRAY + TextFormatting.ITALIC+" for information");
			}
		}
	};
	

	public static final ItemAxe TECTONIUM_AXE = new ToolAxe("tectonium_axe", MATERIAL_TECTONIUM);
	public static final ItemSword TECTONIUM_SWORD = new ToolSword("tectonium_sword", MATERIAL_TECTONIUM);
	public static final ItemPickaxe TECTONIUM_PICKAXE = new ToolPickaxe("tectonium_pickaxe", MATERIAL_TECTONIUM);
	public static final ItemSpade TECTONIUM_SHOVEL = new ToolShovel("tectonium_shovel", MATERIAL_TECTONIUM);
	public static final ItemHoe TECTONIUM_HOE = new ToolHoe("tectonium_Hoe", MATERIAL_TECTONIUM);
	
	public static final Item TECTONIUM_HELMET = new ArmorBase("tectonium_helmet", ARMOR_MATERIAL_TECTONIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item TECTONIUM_CHESTPLATE = new ArmorBase("tectonium_chestplate", ARMOR_MATERIAL_TECTONIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item TECTONIUM_LEGGINGS = new ArmorBase("tectonium_leggings", ARMOR_MATERIAL_TECTONIUM, 1, EntityEquipmentSlot.LEGS);
	public static final Item TECTONIUM_BOOTS = new ArmorBase("tectonium_boots", ARMOR_MATERIAL_TECTONIUM, 2, EntityEquipmentSlot.FEET);
	
	
	public static final Item POGO_STICK = new PogoStick("pogo_stick");
	public static final Item FLASHLIGHT = new FlashLight("flashlight");
}
