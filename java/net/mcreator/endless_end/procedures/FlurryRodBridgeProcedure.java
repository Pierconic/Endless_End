package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class FlurryRodBridgeProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Direction direction, double length) {
		if (direction == null)
			return false;
		boolean success = false;
		double xAxis = 0;
		double yAxis = 0;
		double zAxis = 0;
		double Offset = 0;
		double localRad = 0;
		double initRad = 0;
		double counter2 = 0;
		double z2 = 0;
		double max_height = 0;
		double extraLocalRad = 0;
		double x2 = 0;
		double yOff = 0;
		double bubble_rad = 0;
		double core_rad = 0;
		double counter = 0;
		double repRad = 0;
		if (direction == Direction.NORTH) {
			zAxis = -1;
		} else if (direction == Direction.SOUTH) {
			zAxis = 1;
		} else if (direction == Direction.WEST) {
			xAxis = -1;
		} else {
			xAxis = 1;
		}
		Offset = 1;
		for (int index0 = 0; index0 < (int) length; index0++) {
			if (world.isEmptyBlock(BlockPos.containing(x + Offset * xAxis, y + Offset * yAxis, z + Offset * zAxis))
					|| (world.getBlockState(BlockPos.containing(x + Offset * xAxis, y + Offset * yAxis, z + Offset * zAxis))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_breakable")))) {
				DelayedCrystalProcedure.execute(world, x + Offset * xAxis, y, z + Offset * zAxis, Offset * 2);
				success = true;
			}
			Offset = Offset + 1;
		}
		return success;
	}
}
