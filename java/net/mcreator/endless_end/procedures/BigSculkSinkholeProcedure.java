package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class BigSculkSinkholeProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double local_rad = 0;
		double radius = 0;
		double sy = 0;
		double depth = 0;
		radius = Mth.nextInt(RandomSource.create(), 3, 7);
		depth = radius * 2;
		for (int index0 = 0; index0 < (int) depth; index0++) {
			local_rad = radius;
			for (int index1 = 0; index1 < (int) radius; index1++) {
				world.setBlock(BlockPos.containing(x, y - sy, z), Blocks.AIR.defaultBlockState(), 3);
				BlockCircleProcedure.execute(world, x, y - sy, z, Blocks.AIR.defaultBlockState(), true, false, 1, local_rad, 1, 1);
				if (local_rad == radius || sy == depth) {
					BlockCircleProcedure.execute(world, x, (y - sy) - 1, z, EndlessEndModBlocks.SINGING_SAND.get().defaultBlockState(), true, true, 1, local_rad, 1, 1);
					BlockCircleProcedure.execute(world, x, (y - sy) - 1, z, Blocks.SCULK.defaultBlockState(), true, true, 0.02, local_rad, 1, 1);
				}
				local_rad = local_rad - 1;
			}
			sy = sy + 1;
			if (Math.random() < 0.6) {
				radius = Math.max(radius - 1, 2);
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y - sy, z)).canOcclude()) {
			world.setBlock(BlockPos.containing(x, (y - sy) - 0, z), EndlessEndModBlocks.BURROWING_SPIKE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 1, (y - sy) - 0, z), EndlessEndModBlocks.BURROWING_SPIKE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 1, (y - sy) - 0, z), EndlessEndModBlocks.BURROWING_SPIKE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, (y - sy) - 0, z - 1), EndlessEndModBlocks.BURROWING_SPIKE.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, (y - sy) - 0, z + 1), EndlessEndModBlocks.BURROWING_SPIKE.get().defaultBlockState(), 3);
		}
		return true;
	}
}
