package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class FlurryChargeFlyingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 3, 0.2, 0.2, 0.2, 0.1);
		world.addParticle(ParticleTypes.POOF, x, y, z, 0, 0.1, 0);
		immediatesourceentity.setNoGravity(true);
		immediatesourceentity.getPersistentData().putDouble("lifeTime", (immediatesourceentity.getPersistentData().getDouble("lifeTime") + 1));
		if (immediatesourceentity.getPersistentData().getDouble("lifeTime") > 200) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 13, 2, 2, 2, 0.1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ITEM_SNOWBALL, x, y, z, 13, 0.2, 0.2, 0.2, 0.1);
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
	}
}
