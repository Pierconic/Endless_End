package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CeilHeightProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double sy = 0;
		sy = y;
		while (sy < 128) {
			if (world.getBlockState(BlockPos.containing(x, sy, z)).canOcclude()) {
				return sy;
			}
			sy = sy + 1;
		}
		return sy;
	}
}
