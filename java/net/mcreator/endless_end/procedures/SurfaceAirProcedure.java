package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SurfaceAirProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y - 2, z)) || world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
			return false;
		}
		return true;
	}
}
