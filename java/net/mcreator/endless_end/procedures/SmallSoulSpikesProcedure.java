package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SmallSoulSpikesProcedure {
	public static void execute(LevelAccessor world, double x, double z) {
		double ox = 0;
		double oz = 0;
		double sy = 0;
		double start_y = 0;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 24, 48); index0++) {
			ox = Mth.nextInt(RandomSource.create(), -9, 9);
			oz = Mth.nextInt(RandomSource.create(), -9, 9);
			sy = 0;
			start_y = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + ox), (int) (z + oz)) - 1;
			if ((world.getBlockState(BlockPos.containing(x + ox, start_y, z + oz))).getBlock() == EndlessEndModBlocks.CALCIFIED_ENDSTONE.get() && world.isEmptyBlock(BlockPos.containing(x + ox, start_y + 1, z + oz))) {
				for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 3, 10); index1++) {
					if (sy < 4) {
						world.setBlock(BlockPos.containing(x + ox, start_y + sy, z + oz), EndlessEndModBlocks.STRONG_STONE.get().defaultBlockState(), 3);
					} else {
						world.setBlock(BlockPos.containing(x + ox, start_y + sy, z + oz), Blocks.END_STONE.defaultBlockState(), 3);
					}
					sy = sy + 1;
				}
			}
		}
	}
}
