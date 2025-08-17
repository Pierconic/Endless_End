package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class LoomershotParticlesProcedure {
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
		if (immediatesourceentity.getPersistentData().getBoolean("struck")) {
			immediatesourceentity.getPersistentData().putDouble("decay", (immediatesourceentity.getPersistentData().getDouble("decay") + 1));
		}
		if (distance > 96 || immediatesourceentity.getPersistentData().getDouble("decay") > 120 || !entity.isAlive()) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), 12, 0.1, 0.1, 0.1, 0.1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:swingshot.cut")),
							SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:swingshot.cut")), SoundSource.NEUTRAL, 1,
							1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.wolf_armor.break")),
							SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.wolf_armor.break")), SoundSource.NEUTRAL, 1, 1,
							false);
				}
			}
		}
	}
}
