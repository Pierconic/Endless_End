package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SculkFallProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double max) {
		double sy = 0;
		sy = 1;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, (int) max); index0++) {
			if (world.isEmptyBlock(BlockPos.containing(x, y - sy, z))) {
				if (Math.random() < 0.02) {
					world.setBlock(BlockPos.containing(x, y - sy, z), EndlessEndModBlocks.SOUL_LIGHT.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y - sy, z), Blocks.SCULK.defaultBlockState(), 3);
				}
				sy = sy + 1;
			}
		}
	}
}
