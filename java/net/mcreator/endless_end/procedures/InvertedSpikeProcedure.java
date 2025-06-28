package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class InvertedSpikeProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		boolean found = false;
		double max_depth = 0;
		double strip_threshold = 0;
		double sy = 0;
		double sx = 0;
		double sz = 0;
		double root_threshold = 0;
		double canopy_delay = 0;
		double start_y = 0;
		if (VoidGenHeightProcedure.execute(world, x, z) < 64 && !world.canSeeSkyFromBelowWater(BlockPos.containing(x - 3, 0, z)) && !world.canSeeSkyFromBelowWater(BlockPos.containing(x + 3, 0, z))
				&& !world.canSeeSkyFromBelowWater(BlockPos.containing(x, 0, z - 3)) && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, 0, z + 3))) {
			max_depth = Mth.nextInt(RandomSource.create(), 24, 48);
			strip_threshold = Math.round(0.85 * max_depth);
			root_threshold = Math.round(0.35 * max_depth);
			sz = 0;
			InvertedRootsProcedure.execute(world, x, z, Mth.nextInt(RandomSource.create(), 5, 8), 1, 1);
			start_y = VoidGenHeightProcedure.execute(world, x, z);
			for (int index0 = 0; index0 < 2; index0++) {
				sx = 0;
				for (int index1 = 0; index1 < 2; index1++) {
					sy = 1;
					for (int index2 = 0; index2 < (int) max_depth; index2++) {
						if (sy > strip_threshold + Mth.nextInt(RandomSource.create(), -2, 2)) {
							if (Math.random() < 0.75) {
								if (!world.getBlockState(BlockPos.containing(x + sx, start_y - sy, z + sz)).canOcclude()) {
									world.setBlock(BlockPos.containing(x + sx, start_y - sy, z + sz), EndlessEndModBlocks.STRIPPED_AZURE_SEPAL_LOG.get().defaultBlockState(), 3);
								}
								sy = sy + 1;
							} else {
								SwirlingVineProcedure.execute(world, x + sx, start_y - sy + 1, z + sz);
							}
						} else {
							if (!world.getBlockState(BlockPos.containing(x + sx, start_y - sy, z + sz)).canOcclude()) {
								world.setBlock(BlockPos.containing(x + sx, start_y - sy, z + sz), EndlessEndModBlocks.AZURE_SEPAL_LOG.get().defaultBlockState(), 3);
								if (sy > root_threshold && sy < strip_threshold - 4) {
									if (Math.random() < 0.2) {
										InvertedBranchProcedure.execute(world, x + sx, start_y - sy, z + sz);
									}
									if (Math.random() < 0.3 && canopy_delay <= 0 && sx == 0 && sz == 0) {
										BigGoldenCanopyProcedure.execute(world, x + 1, start_y - sy, z + 1);
										canopy_delay = Mth.nextInt(RandomSource.create(), 8, 14);
									}
								} else if (sy < root_threshold) {
									if (Math.random() < 0.2) {
										InvertedRootProcedure.execute(world, x + sx, start_y - sy, z + sz);
									}
								}
							}
							sy = sy + 1;
							canopy_delay = canopy_delay - 1;
						}
					}
					sx = sx + 1;
				}
				sz = sz + 1;
			}
			return true;
		}
		return false;
	}
}
