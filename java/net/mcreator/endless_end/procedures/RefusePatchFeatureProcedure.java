package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class RefusePatchFeatureProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		double sx = 0;
		double sz = 0;
		double size = 0;
		sx = 0;
		for (int index0 = 0; index0 < 16; index0++) {
			sz = 0;
			for (int index1 = 0; index1 < 16; index1++) {
				if ((world.getBlockState(BlockPos.containing(x + sx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + sx), (int) (z + sz)) - 1, z + sz))).getBlock() == Blocks.END_STONE
						&& (!(world.isEmptyBlock(BlockPos.containing(x + sx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + sx), (int) (z + sz)) - 1, z + sz + 1))
								|| world.isEmptyBlock(BlockPos.containing(x + sx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + sx), (int) (z + sz)) - 1, (z + sz) - 1))
								|| world.isEmptyBlock(BlockPos.containing((x + sx) - 1, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + sx), (int) (z + sz)) - 1, z + sz))
								|| world.isEmptyBlock(BlockPos.containing(x + sx + 1, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + sx), (int) (z + sz)) - 1, z + sz))) || Math.random() < 0.12)
						&& Math.random() < 0.8) {
					world.setBlock(BlockPos.containing(x + sx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + sx), (int) (z + sz)) - 1, z + sz), EndlessEndModBlocks.REFUSE.get().defaultBlockState(), 3);
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		return true;
	}
}
