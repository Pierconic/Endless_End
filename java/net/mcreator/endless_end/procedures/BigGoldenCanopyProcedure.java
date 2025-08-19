package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class BigGoldenCanopyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double rad_off = 0;
		double stored_rad = 0;
		stored_rad = Mth.nextInt(RandomSource.create(), 3, 6);
		rad_off = stored_rad;
		for (int index0 = 0; index0 < (int) (rad_off * 4); index0++) {
			BlockCircleProcedure.execute(world, x, y, z, EndlessEndModBlocks.BLOSSOMING_GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), false, false, 0.005, rad_off, 1, 1);
			BlockCircleProcedure.execute(world, x, y, z, EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), false, false, 1, rad_off, 1, 1);
			rad_off = rad_off - 0.25;
		}
		rad_off = stored_rad - 1;
		for (int index1 = 0; index1 < (int) (rad_off * 4); index1++) {
			BlockCircleProcedure.execute(world, x, y - 1, z, EndlessEndModBlocks.BLOSSOMING_GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), false, false, 0.005, rad_off, 1, 1);
			BlockCircleProcedure.execute(world, x, y - 1, z, EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), false, false, 1, rad_off, 1, 1);
			rad_off = rad_off - 0.25;
		}
		rad_off = stored_rad - 2;
		for (int index2 = 0; index2 < (int) (rad_off * 4); index2++) {
			BlockCircleProcedure.execute(world, x, y - 2, z, EndlessEndModBlocks.BLOSSOMING_GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), false, false, 0.005, rad_off, 1, 1);
			BlockCircleProcedure.execute(world, x, y - 2, z, EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), false, false, 1, rad_off, 1, 1);
			rad_off = rad_off - 0.25;
		}
		rad_off = stored_rad;
		BlockCircleProcedure.execute(world, x, y + 1, z, EndlessEndModBlocks.BLOSSOMING_GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), false, false, 0.005, rad_off, 1, 1);
		BlockCircleProcedure.execute(world, x, y + 1, z, EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), false, false, 0.026, rad_off, 1, 1);
		GoldenSepalFallProcedure.execute(world, x + 1, y - 3, z - 1, 8);
		GoldenSepalFallProcedure.execute(world, x + 1, y - 3, z - 0, 8);
		GoldenSepalFallProcedure.execute(world, x + 0, y - 3, z + 1, 8);
		GoldenSepalFallProcedure.execute(world, x - 1, y - 3, z + 1, 8);
		GoldenSepalFallProcedure.execute(world, x - 0, y - 3, z - 2, 8);
		GoldenSepalFallProcedure.execute(world, x - 1, y - 3, z - 2, 8);
		GoldenSepalFallProcedure.execute(world, x - 2, y - 3, z - 1, 8);
		GoldenSepalFallProcedure.execute(world, x - 2, y - 3, z - 0, 8);
		GoldenSepalFallProcedure.execute(world, x - 2, y - 3, z - 2, 5);
		GoldenSepalFallProcedure.execute(world, x - 2, y - 3, z + 1, 5);
		GoldenSepalFallProcedure.execute(world, x + 1, y - 3, z + 1, 5);
		GoldenSepalFallProcedure.execute(world, x + 1, y - 3, z - 2, 5);
	}
}
