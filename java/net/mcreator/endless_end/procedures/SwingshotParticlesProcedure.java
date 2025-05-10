package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.endless_end.init.EndlessEndModItems;

public class SwingshotParticlesProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		boolean est = false;
		double dx = 0;
		double distance = 0;
		double dy = 0;
		double dz = 0;
		double vx = 0;
		double vy = 0;
		double vz = 0;
		double p_off = 0;
		double dz1 = 0;
		double dx1 = 0;
		double dy1 = 0;
		dx = entity.getX() - immediatesourceentity.getX();
		dy = entity.getY() - immediatesourceentity.getY();
		dz = entity.getZ() - immediatesourceentity.getZ();
		distance = Math.pow(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2), 0.5);
		StringParticlesProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), distance, 1.8, immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
		if (distance > 96) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), 15, 0.1, 0.1, 0.1, 0.1);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(EndlessEndModItems.SWINGSILK.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
	}
}
