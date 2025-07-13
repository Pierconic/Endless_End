package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SoulPillarProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double localRad = 0;
		double counter2 = 0;
		double z2 = 0;
		double x2 = 0;
		double counter = 0;
		double yOff = 0;
		double max_height = 0;
		double initRad = 0;
		double extraLocalRad = 0;
		if (Math.random() < 0.3) {
			initRad = Mth.nextInt(RandomSource.create(), 4, 6);
		} else {
			initRad = Mth.nextInt(RandomSource.create(), 2, 4);
		}
		max_height = Mth.nextInt(RandomSource.create(), 12, 30);
		for (int index0 = 0; index0 < (int) max_height; index0++) {
			if (Math.random() < yOff / (max_height * 0.75)) {
				world.setBlock(BlockPos.containing(x, y + yOff, z), Blocks.CALCITE.defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y + yOff, z), Blocks.END_STONE.defaultBlockState(), 3);
			}
			counter2 = 0;
			localRad = Math.min(initRad, max_height - yOff);
			extraLocalRad = localRad;
			for (int index1 = 0; index1 < (int) localRad; index1++) {
				counter2 = 0;
				while (counter2 <= 360) {
					x2 = 1 * extraLocalRad * Math.cos(counter2);
					z2 = 1 * extraLocalRad * Math.sin(counter2);
					if (Math.random() < yOff / (max_height * 0.75)) {
						if (Math.random() < 0.3 * (extraLocalRad / localRad)) {
							if (Math.random() < 0.02) {
								world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), EndlessEndModBlocks.ESSENCE.get().defaultBlockState(), 3);
							} else {
								world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), Blocks.AIR.defaultBlockState(), 3);
							}
						} else {
							world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), Blocks.CALCITE.defaultBlockState(), 3);
						}
					} else {
						if (Math.random() < 0.3 * (extraLocalRad / localRad)) {
							if (Math.random() < 0.02) {
								world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), EndlessEndModBlocks.ESSENCE.get().defaultBlockState(), 3);
							} else {
								world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), Blocks.AIR.defaultBlockState(), 3);
							}
						} else if (Math.random() < 0.02) {
							world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), EndlessEndModBlocks.END_DIAMONDS.get().defaultBlockState(), 3);
						} else if (Math.random() < 0.1) {
							world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), EndlessEndModBlocks.END_AMETHYST.get().defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), Blocks.END_STONE.defaultBlockState(), 3);
						}
					}
					counter2 = counter2 + 1;
				}
				extraLocalRad = extraLocalRad - 1;
			}
			yOff = yOff + 1;
		}
		counter2 = 0;
		SoulPillarTopperProcedure.execute(world, x, y, z, 0.9);
		localRad = initRad;
		extraLocalRad = initRad;
		for (int index3 = 0; index3 < (int) localRad; index3++) {
			counter2 = 0;
			while (counter2 <= 360) {
				x2 = extraLocalRad * Math.cos(counter2);
				z2 = extraLocalRad * Math.sin(counter2);
				SoulPillarTopperProcedure.execute(world, x + x2 + 0.5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + x2 + 0.5), (int) (z + z2 + 0.5)) - 1, z + z2 + 0.5, Math.abs(0.5 * (localRad / extraLocalRad)));
				counter2 = counter2 + 1;
			}
			extraLocalRad = extraLocalRad - 1;
		}
	}
}
