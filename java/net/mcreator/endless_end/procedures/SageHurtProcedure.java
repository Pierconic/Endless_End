package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;
import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.entity.SageEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SageHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double shield_max = 0;
		shield_max = 30;
		if (entity instanceof SageEntity && sourceentity instanceof Player) {
			if ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_damage) : 0) >= shield_max) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:sage.hurt")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:sage.hurt")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof SageEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SageEntity.DATA_shield_damage, (int) shield_max);
			} else if ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_damage) : 0) + amount >= shield_max) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.break")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 6, 12); index0++) {
					world.addParticle(ParticleTypes.LARGE_SMOKE, (x + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + Mth.nextDouble(RandomSource.create(), 0, 1.5)), (z + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0, 0.1, 0);
				}
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.FLOURITE.get().defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(EndlessEndModBlocks.FLOURITE.get().defaultBlockState()));
				if (entity instanceof SageEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SageEntity.DATA_shield_damage, (int) shield_max);
				if (entity instanceof SageEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SageEntity.DATA_stun_ticks, 15);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 1));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120, 1, false, false));
				if (entity instanceof SageEntity) {
					((SageEntity) entity).setAnimation("break");
				}
			} else if ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_damage) : 0) < shield_max) {
				if (entity instanceof SageEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SageEntity.DATA_shield_damage, (int) ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_damage) : 0) + amount));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:sage.deflect")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:sage.deflect")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.ENDORITE_REPEL.get()), x, y, z, 16, 1, 1, 1, 0.1);
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((sourceentity.getX()), (sourceentity.getY() + 1.2), (sourceentity.getZ())));
				entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * (-0.4)), 0.1, (entity.getLookAngle().z * (-0.4))));
				if (entity instanceof SageEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SageEntity.DATA_shield_charge, 0);
				if ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_stun_ticks) : 0) == 0) {
					if (entity instanceof SageEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SageEntity.DATA_stun_ticks, 10);
				}
				if (entity instanceof SageEntity) {
					((SageEntity) entity).setAnimation("block");
				}
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
			SageTextureProcedure.execute(entity);
		}
	}
}
