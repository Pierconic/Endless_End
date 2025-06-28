package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SoulSpikesProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		double ox = 0;
		double oz = 0;
		double sy = 0;
		double start_y = 0;
		double height = 0;
		double topper = 0;
		for (int index0 = 0; index0 < 4; index0++) {
			SmallSoulSpikesProcedure.execute(world, x, z);
		}
		for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 24, 48); index1++) {
			ox = Mth.nextInt(RandomSource.create(), -9, 9);
			oz = Mth.nextInt(RandomSource.create(), -9, 9);
			sy = 0;
			start_y = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + ox), (int) (z + oz)) - 1;
			if ((world.getBlockState(BlockPos.containing(x + ox, start_y, z + oz))).getBlock() == EndlessEndModBlocks.CALCIFIED_ENDSTONE.get() || (world.getBlockState(BlockPos.containing(x + ox, start_y, z + oz))).getBlock() == Blocks.END_STONE
					|| (world.getBlockState(BlockPos.containing(x + ox, start_y, z + oz))).getBlock() == Blocks.SMOOTH_BASALT) {
				if (Math.random() < 0.7) {
					height = Mth.nextInt(RandomSource.create(), 4, 14);
					for (int index2 = 0; index2 < (int) height; index2++) {
						if (sy == Math.round(height * 0.6)) {
							world.setBlock(BlockPos.containing(x + ox, start_y + sy, z + oz), EndlessEndModBlocks.CALCIFIED_ENDSTONE.get().defaultBlockState(), 3);
						} else if (sy < height * 0.6) {
							world.setBlock(BlockPos.containing(x + ox, start_y + sy, z + oz), Blocks.END_STONE.defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x + ox, start_y + sy, z + oz), Blocks.CALCITE.defaultBlockState(), 3);
						}
						sy = sy + 1;
					}
				} else {
					height = Mth.nextInt(RandomSource.create(), 9, 16);
					topper = Mth.nextInt(RandomSource.create(), 3, 8);
					for (int index3 = 0; index3 < (int) height; index3++) {
						if (sy == Math.round(height * 0.6)) {
							world.setBlock(BlockPos.containing(x + ox, start_y + sy, z + oz), EndlessEndModBlocks.CALCIFIED_ENDSTONE.get().defaultBlockState(), 3);
						} else if (sy < height * 0.6) {
							if (Math.random() < 0.05) {
								world.setBlock(BlockPos.containing(x + ox, start_y + sy, z + oz), EndlessEndModBlocks.END_AMETHYST.get().defaultBlockState(), 3);
							} else if (Math.random() < 0.005) {
								world.setBlock(BlockPos.containing(x + ox, start_y + sy, z + oz), EndlessEndModBlocks.END_DIAMONDS.get().defaultBlockState(), 3);
							} else {
								world.setBlock(BlockPos.containing(x + ox, start_y + sy, z + oz), Blocks.END_STONE.defaultBlockState(), 3);
							}
						} else {
							world.setBlock(BlockPos.containing(x + ox, start_y + sy, z + oz), Blocks.CALCITE.defaultBlockState(), 3);
						}
						sy = sy + 1;
					}
					for (int index4 = 0; index4 < (int) topper; index4++) {
						world.setBlock(BlockPos.containing(x + ox, start_y + sy, z + oz), EndlessEndModBlocks.FLOURITE.get().defaultBlockState(), 3);
						sy = sy + 1;
					}
				}
			}
		}
		return true;
	}
}
