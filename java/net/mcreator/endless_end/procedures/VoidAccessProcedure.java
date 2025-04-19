package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class VoidAccessProcedure {
	public static boolean execute(LevelAccessor world, double x, double z, double startY) {
		boolean blocked = false;
		double sy = 0;
		blocked = false;
		sy = startY;
		while (!blocked && sy > -64) {
			if (!world.isEmptyBlock(BlockPos.containing(x, sy, z))) {
				blocked = true;
			} else {
				sy = sy - 1;
			}
		}
		if (blocked) {
			return false;
		}
		return true;
	}
}
