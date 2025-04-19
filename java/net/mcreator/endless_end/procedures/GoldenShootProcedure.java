package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class GoldenShootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sy1 = 0;
		double sx = 0;
		double sz = 0;
		double dr = 0;
		boolean grounded = false;
		sy1 = 1;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 6); index0++) {
			world.setBlock(BlockPos.containing(x, y - sy1, z), EndlessEndModBlocks.AZURE_SEPAL_LOG.get().defaultBlockState(), 3);
			if (Math.random() < 0.25) {
				world.setBlock(BlockPos.containing(x + 1, y - sy1, z), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y - sy1, z), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y - sy1, z + 1), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y - sy1, z - 1), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
			}
			sy1 = sy1 + 1;
		}
		world.setBlock(BlockPos.containing(x, y - sy1, z), EndlessEndModBlocks.AZURE_SEPAL_WOOD.get().defaultBlockState(), 3);
		SwirlingVineProcedure.execute(world, x, y - sy1, z);
	}
}
