package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class FlurryRodPlatformProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, double radius) {
		if (entity == null)
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
		localRad = radius;
		extraLocalRad = localRad;
		for (int index0 = 0; index0 < (int) localRad; index0++) {
			counter2 = 0;
			while (counter2 <= 360) {
				x2 = 1 * extraLocalRad * Math.cos(counter2);
				z2 = 1 * extraLocalRad * Math.sin(counter2);
				DelayedCrystalProcedure.execute(world, x + x2 + 0.5, (y + entity.getDeltaMovement().y() * 2) - 1, z + z2 + 0.5, extraLocalRad * 2);
				success = true;
				counter2 = counter2 + 1;
			}
			extraLocalRad = extraLocalRad - 1;
		}
		return success;
	}
}
