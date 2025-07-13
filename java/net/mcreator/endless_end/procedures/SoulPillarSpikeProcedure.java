package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SoulPillarSpikeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double localRad = 0;
		double counter2 = 0;
		double z2 = 0;
		double x2 = 0;
		double counter = 0;
		double yOff = 0;
		double max_height = 0;
		double initRad = 0;
		double extraLocalRad = 0;
		localRad = initRad;
		extraLocalRad = initRad;
		for (int index0 = 0; index0 < (int) localRad; index0++) {
			counter2 = 0;
			while (counter2 <= 360) {
				x2 = extraLocalRad * Math.cos(counter2);
				z2 = extraLocalRad * Math.sin(counter2);
				SoulPillarTopperProcedure.execute(world, x + x2 + 0.5, y, z + z2 + 0.5, Math.abs(0.5 * (localRad / extraLocalRad)));
				counter2 = counter2 + 1;
			}
			extraLocalRad = extraLocalRad - 1;
		}
	}
}
