
package net.mcreator.endless_end.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.CanticleGrowthProcedure;

public class BloomingCanticleBlock extends Block {
	public BloomingCanticleBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.MOSS).strength(0.3f, 2f).requiresCorrectToolForDrops().randomTicks());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		CanticleGrowthProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}
}
