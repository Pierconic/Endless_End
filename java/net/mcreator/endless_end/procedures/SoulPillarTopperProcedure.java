package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SoulPillarTopperProcedure {
	public static void execute(LevelAccessor world, double x, double z, double dampener) {
		double height = 0;
		double offset = 0;
		if ((world.getBlockState(BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) - 1, z))).getBlock() == Blocks.CALCITE) {
			offset = Mth.nextInt(RandomSource.create(), 0, 4);
			height = Mth.nextInt(RandomSource.create(), 8, 16) * dampener;
			for (int index0 = 0; index0 < (int) height; index0++) {
				if (offset > 0) {
					world.setBlock(BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), z), Blocks.CALCITE.defaultBlockState(), 3);
					offset = offset - 1;
				} else {
					world.setBlock(BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), z), EndlessEndModBlocks.FLOURITE.get().defaultBlockState(), 3);
				}
			}
		}
	}
}
