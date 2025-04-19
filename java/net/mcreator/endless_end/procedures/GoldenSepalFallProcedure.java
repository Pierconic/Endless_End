package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class GoldenSepalFallProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double maxDrop) {
		double fall = 0;
		fall = 0;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, (int) maxDrop); index0++) {
			if (world.isEmptyBlock(BlockPos.containing(x, y - fall, z))) {
				if (Math.random() < 0.08) {
					world.setBlock(BlockPos.containing(x, y - fall, z), EndlessEndModBlocks.BLOSSOMING_GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y - fall, z), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
				}
			}
			fall = fall + 1;
		}
	}
}
