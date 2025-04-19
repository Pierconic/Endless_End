package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class VoidHeightProcedure {
	public static double execute(LevelAccessor world, double x, double z) {
		double sy = 0;
		sy = -56;
		while (sy < 64) {
			if (!world.isEmptyBlock(BlockPos.containing(x, sy, z))) {
				return sy;
			}
			sy = sy + 1;
		}
		return sy;
	}
}
