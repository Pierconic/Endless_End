
package net.mcreator.endless_end.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import com.mojang.serialization.MapCodec;

public class MolderingPurpurBlock extends FallingBlock {
	public static final MapCodec<MolderingPurpurBlock> CODEC = simpleCodec(properties -> new MolderingPurpurBlock());

	public MapCodec<MolderingPurpurBlock> codec() {
		return CODEC;
	}

	public MolderingPurpurBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).sound(SoundType.CORAL_BLOCK).strength(5f, 3f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
