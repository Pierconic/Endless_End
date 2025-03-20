package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class MoonJellyDispenseCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Direction direction) {
		if (direction == null)
			return false;
		if (direction == Direction.DOWN && !world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
			return true;
		} else if (direction == Direction.UP && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
			return true;
		} else if (direction == Direction.NORTH && !world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude()) {
			return true;
		} else if (direction == Direction.SOUTH && !world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude()) {
			return true;
		} else if (direction == Direction.WEST && !world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude()) {
			return true;
		} else if (direction == Direction.EAST && !world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude()) {
			return true;
		}
		return false;
	}
}
