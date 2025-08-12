package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.entity.SageEntity;

public class SageTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		boolean found = false;
		boolean lost = false;
		boolean strike = false;
		double shield_max = 0;
		double distance = 0;
		double magnitude = 0;
		double baseMult = 0;
		double y_vec = 0;
		double inaccuracy = 0;
		double x_vec = 0;
		double z_vec = 0;
		double base_magnitude = 0;
		shield_max = 30;
		if ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_stun_ticks) : 0) > 0) {
			if (entity instanceof SageEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SageEntity.DATA_stun_ticks, (int) ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_stun_ticks) : 0) - 1));
		}
		if ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_charge) : 0) < 112) {
			if (entity instanceof SageEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SageEntity.DATA_shield_charge, (int) ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_charge) : 0) + 1));
		}
		if (((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_charge) : 0) >= 110 || (entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_charge) : 0) >= 40
				&& (entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_damage) : 0) < shield_max)
				&& (entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_damage) : 0) > 0 && entity.isAlive()) {
			if ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_damage) : 0) == shield_max) {
				if (entity instanceof SageEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SageEntity.DATA_shield_damage, 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.mirror_move")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.mirror_move")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				for (int index0 = 0; index0 < 24; index0++) {
					world.addParticle(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER_OMINOUS, (x + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), (y + Mth.nextDouble(RandomSource.create(), 0, 1.5)),
							(z + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), 0, 0.12, 0);
				}
			} else {
				if (entity instanceof SageEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SageEntity.DATA_shield_damage, (int) ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_damage) : 0) - 1));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if (entity instanceof SageEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SageEntity.DATA_shield_charge, 0);
			SageTextureProcedure.execute(entity);
		}
	}
}
