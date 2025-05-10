package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;

public class StringParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double distance, double start, double tarX, double tarY, double tarZ) {
		double p_off = 0;
		p_off = start;
		for (int index0 = 0; index0 < (int) (distance * 5); index0++) {
			if (distance > 72) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.SWING_SILK_STRING_PARTICLE_TINY.get()), (x + (p_off / distance) * (tarX - x)), (y + (p_off / distance) * (tarY - y)), (z + (p_off / distance) * (tarZ - z)), 0, 0, 0);
			} else if (distance > 48) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.SWING_SILK_STRING_PARTICLE_SMALL.get()), (x + (p_off / distance) * (tarX - x)), (y + (p_off / distance) * (tarY - y)), (z + (p_off / distance) * (tarZ - z)), 0, 0, 0);
			} else if (distance > 32) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.SWING_SILK_STRING_PARTICLE.get()), (x + (p_off / distance) * (tarX - x)), (y + (p_off / distance) * (tarY - y)), (z + (p_off / distance) * (tarZ - z)), 0, 0, 0);
			} else if (distance > 16) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.SWING_SILK_STRING_PARTICLE_BIG.get()), (x + (p_off / distance) * (tarX - x)), (y + (p_off / distance) * (tarY - y)), (z + (p_off / distance) * (tarZ - z)), 0, 0, 0);
			} else {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.SWING_SILK_STRING_PARTICLE_GIANT.get()), (x + (p_off / distance) * (tarX - x)), (y + (p_off / distance) * (tarY - y)), (z + (p_off / distance) * (tarZ - z)), 0, 0, 0);
			}
			p_off = p_off + 0.2;
		}
	}
}
