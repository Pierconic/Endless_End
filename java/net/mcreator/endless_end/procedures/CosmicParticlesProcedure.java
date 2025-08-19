package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;

public class CosmicParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < 16; index0++) {
			world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.STAR_SPARKLE.get()), (x + 0.5 + Mth.nextDouble(RandomSource.create(), -12, 12)), (y + 0.5 + Mth.nextDouble(RandomSource.create(), -12, 12)),
					(z + 0.5 + Mth.nextDouble(RandomSource.create(), -12, 12)), 0, (-0.1), 0);
		}
	}
}
