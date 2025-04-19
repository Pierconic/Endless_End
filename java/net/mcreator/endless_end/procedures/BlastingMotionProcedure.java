package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModMobEffects;

public class BlastingMotionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.blast_x = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).blast_x * 0.98;
				_vars.syncPlayerVariables(entity);
			}
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.blast_y = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).blast_y * 0.98;
				_vars.syncPlayerVariables(entity);
			}
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.blast_z = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).blast_z * 0.98;
				_vars.syncPlayerVariables(entity);
			}
		}
		entity.setDeltaMovement(new Vec3(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).blast_x, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).blast_y, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).blast_z));
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.INDIGESTION) ? _livEnt.getEffect(EndlessEndModMobEffects.INDIGESTION).getAmplifier() : 0) == 0) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, y, z, 3, 0.2, 0.2, 0.2, 0.1);
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.INDIGESTION) ? _livEnt.getEffect(EndlessEndModMobEffects.INDIGESTION).getDuration() : 0) % 5 == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + entity.getDeltaMovement().x() * 2, y + entity.getDeltaMovement().y() * 2, z + entity.getDeltaMovement().z() * 2),
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_loop")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
					} else {
						_level.playLocalSound((x + entity.getDeltaMovement().x() * 2), (y + entity.getDeltaMovement().y() * 2), (z + entity.getDeltaMovement().z() * 2),
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_loop")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
					}
				}
			}
			if (Math.random() < 0.2) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + entity.getDeltaMovement().x() * 2, y + entity.getDeltaMovement().y() * 2, z + entity.getDeltaMovement().z() * 2),
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_berry.toot")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
					} else {
						_level.playLocalSound((x + entity.getDeltaMovement().x() * 2), (y + entity.getDeltaMovement().y() * 2), (z + entity.getDeltaMovement().z() * 2),
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_berry.toot")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
					}
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.INDIGESTION) ? _livEnt.getEffect(EndlessEndModMobEffects.INDIGESTION).getAmplifier() : 0) == 1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, y, z, 4, 0.2, 0.2, 0.2, 0.1);
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.INDIGESTION) ? _livEnt.getEffect(EndlessEndModMobEffects.INDIGESTION).getDuration() : 0) % 5 == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + entity.getDeltaMovement().x() * 2, y + entity.getDeltaMovement().y() * 2, z + entity.getDeltaMovement().z() * 2),
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_loop")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1));
					} else {
						_level.playLocalSound((x + entity.getDeltaMovement().x() * 2), (y + entity.getDeltaMovement().y() * 2), (z + entity.getDeltaMovement().z() * 2),
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_loop")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1), false);
					}
				}
			}
			if (Math.random() < 0.2) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + entity.getDeltaMovement().x() * 2, y + entity.getDeltaMovement().y() * 2, z + entity.getDeltaMovement().z() * 2),
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_berry.toot")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
					} else {
						_level.playLocalSound((x + entity.getDeltaMovement().x() * 2), (y + entity.getDeltaMovement().y() * 2), (z + entity.getDeltaMovement().z() * 2),
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_berry.toot")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
					}
				}
			}
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, y, z, 5, 0.3, 0.3, 0.3, 0.1);
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.INDIGESTION) ? _livEnt.getEffect(EndlessEndModMobEffects.INDIGESTION).getDuration() : 0) % 5 == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + entity.getDeltaMovement().x() * 2, y + entity.getDeltaMovement().y() * 2, z + entity.getDeltaMovement().z() * 2),
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_loop")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.7, 0.9));
					} else {
						_level.playLocalSound((x + entity.getDeltaMovement().x() * 2), (y + entity.getDeltaMovement().y() * 2), (z + entity.getDeltaMovement().z() * 2),
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_loop")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.7, 0.9), false);
					}
				}
			}
			if (Math.random() < 0.2) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + entity.getDeltaMovement().x() * 2, y + entity.getDeltaMovement().y() * 2, z + entity.getDeltaMovement().z() * 2),
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_berry.toot")), SoundSource.PLAYERS, (float) 1.4, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1));
					} else {
						_level.playLocalSound((x + entity.getDeltaMovement().x() * 2), (y + entity.getDeltaMovement().y() * 2), (z + entity.getDeltaMovement().z() * 2),
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_berry.toot")), SoundSource.PLAYERS, (float) 1.4, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1), false);
					}
				}
			}
		}
	}
}
