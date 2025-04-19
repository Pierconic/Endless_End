package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModMobEffects;

import java.util.List;
import java.util.Comparator;

public class ApplyBlastEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
		if (entity == null)
			return;
		if (amplifier == 0) {
			if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isFallFlying()) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_x = entity.getLookAngle().x * 1.5;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_y = entity.getLookAngle().y * 1.5;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_z = entity.getLookAngle().z * 1.5;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.isShiftKeyDown()) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_x = entity.getLookAngle().x * 1.5;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_y = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_z = entity.getLookAngle().z * 1.5;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_x = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_y = 1;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_z = 0;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_berry.small")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_berry.small")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.GUST_EMITTER_LARGE, x, y, z, 6, 1, 1, 1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.GUST_EMITTER_LARGE, x, y, z, 6, 1, 1, 1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMALL_GUST, x, y, z, 12, 2, 2, 2, 0);
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("endless_end:flatuence")))), 4);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("endless_end:flatuence"))), entity, entity), 8);
					}
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.INDIGESTION, 30, 0));
		} else if (amplifier == 1) {
			if (entity instanceof LivingEntity _livEnt18 && _livEnt18.isFallFlying()) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_x = entity.getLookAngle().x * 1.62;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_y = entity.getLookAngle().y * 1.62;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_z = entity.getLookAngle().z * 1.62;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.isShiftKeyDown()) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_x = entity.getLookAngle().x * 1.62;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_y = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_z = entity.getLookAngle().z * 1.62;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_x = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_y = 1.2;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_z = 0;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_berry.medium")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_berry.medium")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.GUST_EMITTER_LARGE, x, y, z, 8, 1.3, 1.3, 1.3, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.GUST_EMITTER_LARGE, x, y, z, 8, 1.3, 1.3, 1.3, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMALL_GUST, x, y, z, 18, 2.5, 2.5, 2.5, 0);
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("endless_end:flatuence")))), 8);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("endless_end:flatuence"))), entity, entity), 14);
					}
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.INDIGESTION, 50, 0));
		} else {
			if (entity instanceof LivingEntity _livEnt36 && _livEnt36.isFallFlying()) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_x = entity.getLookAngle().x * 2;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_y = entity.getLookAngle().y * 2;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_z = entity.getLookAngle().z * 2;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.isShiftKeyDown()) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_x = entity.getLookAngle().x * 2;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_y = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_z = entity.getLookAngle().z * 2;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_x = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_y = 1.5;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.blast_z = 0;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_berry.giant")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:blast_berry.giant")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.GUST_EMITTER_LARGE, x, y, z, 12, 2, 2, 2, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.GUST_EMITTER_LARGE, x, y, z, 12, 2, 2, 2, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMALL_GUST, x, y, z, 24, 3, 3, 3, 0);
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("endless_end:flatuence")))), 16);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("endless_end:flatuence"))), entity, entity), 24);
					}
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.INDIGESTION, 80, 0));
		}
	}
}
