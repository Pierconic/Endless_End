package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class MossPlacementProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double type = 0;
		int horizontalRadiusSphere = (int) (Mth.nextInt(RandomSource.create(), 2, 4)) - 1;
		int verticalRadiusSphere = (int) (Mth.nextInt(RandomSource.create(), 2, 4)) - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						if (Math.random() < 0.8 && (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("forge:ruinable")))
								&& (world.isEmptyBlock(BlockPos.containing(x + xi - 1, y + i, z + zi)) || world.isEmptyBlock(BlockPos.containing(x + xi + 1, y + i, z + zi)) || world.isEmptyBlock(BlockPos.containing(x + xi, y + i - 1, z + zi))
										|| world.isEmptyBlock(BlockPos.containing(x + xi, y + i + 1, z + zi)) || world.isEmptyBlock(BlockPos.containing(x + xi, y + i, z + zi + 1))
										|| world.isEmptyBlock(BlockPos.containing(x + xi, y + i, z + zi - 1)))) {
							world.setBlock(BlockPos.containing(x + xi, y + i, z + zi), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
						} else {
						}
					}
				}
			}
		}
	}
}
