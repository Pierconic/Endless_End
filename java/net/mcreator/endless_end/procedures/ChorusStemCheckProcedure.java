package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;

public class ChorusStemCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		GrowSmallVioletProcedure.execute(world, x, y, z, 2, 12, 2);
		return true;
	}
}
