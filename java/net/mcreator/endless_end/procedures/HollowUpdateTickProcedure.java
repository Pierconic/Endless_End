package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.entity.HollowEntity;

public class HollowUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof HollowEntity _datEntI ? _datEntI.getEntityData().get(HollowEntity.DATA_burrow_progress) : 0) > 0) {
			if (entity instanceof HollowEntity _datEntSetI)
				_datEntSetI.getEntityData().set(HollowEntity.DATA_burrow_progress, (int) ((entity instanceof HollowEntity _datEntI ? _datEntI.getEntityData().get(HollowEntity.DATA_burrow_progress) : 0) - 1));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SCULK_SOUL, x, y, z, Mth.nextInt(RandomSource.create(), 1, 3), 0.2, 0.2, 0.2, 0.1);
		} else {
			if ((entity instanceof HollowEntity _datEntI ? _datEntI.getEntityData().get(HollowEntity.DATA_heartbeat) : 0) == 14) {
				if (entity instanceof HollowEntity _datEntSetI)
					_datEntSetI.getEntityData().set(HollowEntity.DATA_heartbeat, 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:hollow.heartbeat")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:hollow.heartbeat")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else {
				if (entity instanceof HollowEntity _datEntSetI)
					_datEntSetI.getEntityData().set(HollowEntity.DATA_heartbeat, (int) ((entity instanceof HollowEntity _datEntI ? _datEntI.getEntityData().get(HollowEntity.DATA_heartbeat) : 0) + 1));
			}
		}
		if ((entity instanceof HollowEntity _datEntI ? _datEntI.getEntityData().get(HollowEntity.DATA_jump_cooldown) : 0) > 0) {
			if (entity instanceof HollowEntity _datEntSetI)
				_datEntSetI.getEntityData().set(HollowEntity.DATA_jump_cooldown, (int) ((entity instanceof HollowEntity _datEntI ? _datEntI.getEntityData().get(HollowEntity.DATA_jump_cooldown) : 0) - 1));
		}
	}
}
