package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;

public class AdamantActivationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 9); index0++) {
			world.addParticle(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER_OMINOUS, (x + Mth.nextDouble(RandomSource.create(), 0, 1)), (y + Mth.nextDouble(RandomSource.create(), 1, 1.1)), (z + Mth.nextDouble(RandomSource.create(), 0, 1)), 0,
					(Mth.nextDouble(RandomSource.create(), 0.05, 0.3)), 0);
		}
	}
}
