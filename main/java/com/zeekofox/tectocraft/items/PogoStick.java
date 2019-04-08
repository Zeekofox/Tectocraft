package com.zeekofox.tectocraft.items;

import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import com.zeekofox.tectocraft.utils.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PogoStick extends ItemBase implements IHasModel{

	public static final int COOLDOWN = 10;
	public PogoStick(String name) {
		super(name);
		setMaxDamage(1024);
		setMaxStackSize(1);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			tooltip.add("Jumpy jumpy, hippity hoppity...");
		}else{
			tooltip.add(TextFormatting.ITALIC+"Press " + TextFormatting.YELLOW+ "SHIFT" +TextFormatting.GRAY + TextFormatting.ITALIC+" for information");
		}
	}
	    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	    {
	    	 player.getCooldownTracker().setCooldown(player.getHeldItemMainhand().getItem(), COOLDOWN);	 
			 Vec3d look = player.getLookVec();
			 player.motionX = look.x;
			 player.motionY = 0.7;
			 player.motionZ = look.z;
			 player.getHeldItemMainhand().damageItem(1, player);
			 player.fallDistance = 3;
			 player.fallDistance = 0.0F;
	        return EnumActionResult.PASS;
	    }
}
