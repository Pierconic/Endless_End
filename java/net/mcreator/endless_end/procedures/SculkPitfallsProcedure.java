package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SculkPitfallsProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double sy = 0;
		double sx = 0;
		double sz = 0;
		double cutout = 0;
		boolean found = false;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 10, 13); index0++) {
			sy = -5;
			sx = Mth.nextInt(RandomSource.create(), -13, 13);
			sz = Mth.nextInt(RandomSource.create(), -13, 13);
			for (int index1 = 0; index1 < 20; index1++) {
				if ((world.getBlockState(BlockPos.containing(x + sx, y - sy, z + sz))).getBlock() == Blocks.SCULK || (world.getBlockState(BlockPos.containing(x + sx, y - sy, z + sz))).getBlock() == EndlessEndModBlocks.GRIM_STONE.get()) {
					if (world.getBlockState(BlockPos.containing(x + sx + 1, y - sy, z + sz)).canOcclude() && Math.random() < 0.25) {
						world.setBlock(BlockPos.containing(x + sx + 1, y - sy, z + sz), EndlessEndModBlocks.BURROWING_THORNS.get().defaultBlockState(), 3);
					}
					if (world.getBlockState(BlockPos.containing((x + sx) - 1, y - sy, z + sz)).canOcclude() && Math.random() < 0.25) {
						world.setBlock(BlockPos.containing((x + sx) - 1, y - sy, z + sz), EndlessEndModBlocks.BURROWING_THORNS.get().defaultBlockState(), 3);
					}
					if (world.getBlockState(BlockPos.containing(x + sx, y - sy, (z + sz) - 1)).canOcclude() && Math.random() < 0.25) {
						world.setBlock(BlockPos.containing(x + sx, y - sy, (z + sz) - 1), EndlessEndModBlocks.BURROWING_THORNS.get().defaultBlockState(), 3);
					}
					if (world.getBlockState(BlockPos.containing(x + sx, y - sy, z + sz + 1)).canOcclude() && Math.random() < 0.25) {
						world.setBlock(BlockPos.containing(x + sx, y - sy, z + sz + 1), EndlessEndModBlocks.BURROWING_THORNS.get().defaultBlockState(), 3);
					}
					found = true;
				} else {
					sy = sy + 1;
				}
			}
			if (found) {
				for (int index2 = 0; index2 < Mth.nextInt(RandomSource.create(), 2, 6); index2++) {
					world.setBlock(BlockPos.containing(x + sx, y - sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
					if (world.getBlockState(BlockPos.containing(x + sx + 1, y - sy, z + sz)).canOcclude()) {
						world.setBlock(BlockPos.containing(x + sx + 1, y - sy, z + sz), Blocks.SCULK.defaultBlockState(), 3);
					}
					if (world.getBlockState(BlockPos.containing((x + sx) - 1, y - sy, z + sz)).canOcclude()) {
						world.setBlock(BlockPos.containing((x + sx) - 1, y - sy, z + sz), Blocks.SCULK.defaultBlockState(), 3);
					}
					if (world.getBlockState(BlockPos.containing(x + sx, y - sy, (z + sz) - 1)).canOcclude()) {
						world.setBlock(BlockPos.containing(x + sx, y - sy, (z + sz) - 1), Blocks.SCULK.defaultBlockState(), 3);
					}
					if (world.getBlockState(BlockPos.containing(x + sx, y - sy, z + sz + 1)).canOcclude()) {
						world.setBlock(BlockPos.containing(x + sx, y - sy, z + sz + 1), Blocks.SCULK.defaultBlockState(), 3);
					}
					sy = sy + 1;
				}
				if (world.getBlockState(BlockPos.containing(x + sx, y - sy, z + sz)).canOcclude()) {
					world.setBlock(BlockPos.containing(x + sx, y - sy, z + sz), EndlessEndModBlocks.BURROWING_THORNS.get().defaultBlockState(), 3);
				}
			}
		}
		return true;
	}
}
