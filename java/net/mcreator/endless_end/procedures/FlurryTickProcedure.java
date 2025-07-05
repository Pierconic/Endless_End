package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;

public class FlurryTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.3) {
			world.addParticle(ParticleTypes.FIREWORK, (x + Mth.nextDouble(RandomSource.create(), -1, 1)), (y + Mth.nextDouble(RandomSource.create(), -1, 1)), (z + Mth.nextDouble(RandomSource.create(), -1, 1)), 0, (-0.1), 0);
		}
		for (int index0 = 0; index0 < 2; index0++) {
			world.addParticle(ParticleTypes.POOF, (x + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), (y + Mth.nextDouble(RandomSource.create(), -0.2, 0.4)), (z + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), 0, 0.1, 0);
		}
	}
}
