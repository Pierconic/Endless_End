package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;

public class PuffParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 3); index0++) {
			world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.PUFF_DOWNFALL.get()), (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), (y + 0.9), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), 0,
					(Mth.nextDouble(RandomSource.create(), -0.3, 0.1)), 0);
		}
		for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 4, 10); index1++) {
			world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.PUFF_SPORE.get()), (x + 0.5 + Mth.nextDouble(RandomSource.create(), -7, 7)), (y - Mth.nextDouble(RandomSource.create(), -1, 7)),
					(z + 0.5 + Mth.nextDouble(RandomSource.create(), -7, 7)), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)));
		}
	}
}
