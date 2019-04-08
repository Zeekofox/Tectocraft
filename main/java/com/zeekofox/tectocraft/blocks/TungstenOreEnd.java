package com.zeekofox.tectocraft.blocks;

import com.zeekofox.tectocraft.utils.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TungstenOreEnd extends BlockBase implements IHasModel{

	public TungstenOreEnd(String name, Material materialIn) {
		super(name, materialIn);
		setHardness(4.0F);
		setResistance(5.0F);
		setSoundType(SoundType.STONE);
	}

}
