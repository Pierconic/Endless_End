package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.endless_end.EndlessEndMod;

public class AmalgamParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double amount, double delay, double offset) {
		double particle_num = 0;
		EndlessEndMod.queueServerWork((int) delay, () -> {
			for (int index0 = 0; index0 < (int) amount; index0++) {
				world.addParticle(ParticleTypes.SCULK_SOUL, (x + Mth.nextDouble(RandomSource.create(), -0.8, 0.8)), (y + offset), (z + Mth.nextDouble(RandomSource.create(), -0.8, 0.8)), (Mth.nextDouble(RandomSource.create(), -0.05, 0.05)),
						(Mth.nextDouble(RandomSource.create(), 0.02, 0.2)), (Mth.nextDouble(RandomSource.create(), -0.05, 0.05)));
			}
		});
	}
}
