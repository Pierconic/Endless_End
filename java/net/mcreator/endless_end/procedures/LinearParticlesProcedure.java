package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class LinearParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double start, double tarX, double tarY, double tarZ) {
		double p_off = 0;
		double jump = 0;
		p_off = start;
		jump = Math.pow(Math.pow(x - tarX, 2) + Math.pow(y - tarY, 2) + Math.pow(z - tarZ, 2), 0.5);
		for (int index0 = 0; index0 < (int) (jump * 5); index0++) {
			world.addParticle(ParticleTypes.FIREWORK, (x + (p_off / jump) * (tarX - x)), (y + (p_off / jump) * (tarY - y)), (z + (p_off / jump) * (tarZ - z)), 0, 0, 0);
			p_off = p_off + 0.2;
		}
	}
}
