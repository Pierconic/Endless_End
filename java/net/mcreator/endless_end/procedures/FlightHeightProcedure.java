package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class FlightHeightProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double sy = 0;
		boolean found = false;
		sy = 0;
		while (!found && sy < 128) {
			if (!world.isEmptyBlock(BlockPos.containing(x, Math.floor(y) - sy, z))) {
				found = true;
			} else {
				sy = sy + 1;
			}
		}
		return sy - 1;
	}
}
