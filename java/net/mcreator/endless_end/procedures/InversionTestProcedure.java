package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class InversionTestProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		InvertedHumusProcedure.execute(world, x, z, Mth.nextInt(RandomSource.create(), 4, 8), 1, 1);
		return true;
	}
}
