package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class PolypFlightCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getBlockState(BlockPos.containing(x, y - 0.1, z)).canOcclude()) {
			return true;
		}
		return false;
	}
}
