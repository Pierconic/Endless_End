package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class BigChorusTreeProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double height = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		height = Mth.nextInt(RandomSource.create(), 32, 48);
		world.setBlock(BlockPos.containing(x, y - 1, z), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x + 1, y - 1, z), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y - 1, z + 1), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x + 1, y - 1, z + 1), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
		sx = -4;
		for (int index0 = 0; index0 < 9; index0++) {
			sy = -9;
			for (int index1 = 0; index1 < 9; index1++) {
				sz = -4;
				for (int index2 = 0; index2 < 9; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.END_STONE && Math.random() < 0.1) {
						world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		BigChorusTreeSegmentProcedure.execute(world, x, y, z, height + Mth.nextInt(RandomSource.create(), -2, 3));
		BigChorusTreeSegmentProcedure.execute(world, x + 1, y, z, height + Mth.nextInt(RandomSource.create(), -2, 3));
		BigChorusTreeSegmentProcedure.execute(world, x, y, z + 1, height + Mth.nextInt(RandomSource.create(), -2, 3));
		BigChorusTreeSegmentProcedure.execute(world, x + 1, y, z + 1, height + Mth.nextInt(RandomSource.create(), -2, 3));
		return true;
	}
}
