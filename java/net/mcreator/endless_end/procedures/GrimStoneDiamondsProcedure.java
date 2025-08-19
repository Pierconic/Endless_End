package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class GrimStoneDiamondsProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -5;
		found = false;
		for (int index0 = 0; index0 < 11; index0++) {
			sy = -5;
			for (int index1 = 0; index1 < 11; index1++) {
				sz = -5;
				for (int index2 = 0; index2 < 11; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == EndlessEndModBlocks.GRIM_STONE.get()) {
						if (Math.random() < 0.011) {
							world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), EndlessEndModBlocks.GRIM_STONE_DIAMOND_ORE.get().defaultBlockState(), 3);
						} else if (Math.random() < 0.03) {
							world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), EndlessEndModBlocks.INFESTED_GRIM_STONE.get().defaultBlockState(), 3);
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		return true;
	}
}
