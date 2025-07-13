package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;

public class SepalParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
			if (Math.random() < 0.3) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.VIOLET_PIP.get()), (x + Mth.nextDouble(RandomSource.create(), 0, 1)), (y - Mth.nextDouble(RandomSource.create(), 0.05, 0.15)),
						(z + Mth.nextDouble(RandomSource.create(), 0, 1)), (Mth.nextDouble(RandomSource.create(), -0.05, 0.05)), 0, (Mth.nextDouble(RandomSource.create(), -0.05, 0.05)));
			}
		}
	}
}
