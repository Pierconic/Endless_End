package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BlazeSpellInitiateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double z2 = 0;
		double x2 = 0;
		double counter = 0;
		double sy = 0;
		counter = 0;
		for (int index0 = 0; index0 < 5; index0++) {
			if (counter == 0) {
				x2 = 1;
				z2 = 0;
			} else if (counter == 1) {
				x2 = 0;
				z2 = 1;
			} else if (counter == 2) {
				x2 = -1;
				z2 = 0;
			} else if (counter == 3) {
				x2 = 0;
				z2 = -1;
			} else {
				x2 = 0;
				z2 = 0;
			}
			for (int index1 = 0; index1 < 16; index1++) {
				if (!(world.getBlockFloorHeight(BlockPos.containing(x + x2 + 0.5, y - sy, z + z2 + 0.5)) > 0)) {
					sy = sy + 1;
				}
			}
			BlazeSpellPlaceProcedure.execute(world, x + x2, y - sy, z + z2);
			counter = counter + 1;
		}
	}
}
