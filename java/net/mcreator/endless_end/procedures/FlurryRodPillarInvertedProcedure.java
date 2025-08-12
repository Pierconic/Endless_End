package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class FlurryRodPillarInvertedProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, double height) {
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
		for (int index0 = 0; index0 < (int) height; index0++) {
			if (world.isEmptyBlock(BlockPos.containing(x, y - yOff, z)) || (world.getBlockState(BlockPos.containing(x, y - yOff, z))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_breakable")))) {
				DelayedPillarCrystalProcedure.execute(world, x, y - yOff, z, false, yOff * 2);
				success = true;
				yOff = yOff + 1;
			}
		}
		return success;
	}
}
