package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class GrazerTeleportProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sz = 0;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.UNLUCK) ? _livEnt.getEffect(MobEffects.UNLUCK).getDuration() : 0) == 1
				&& (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity && !(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.MOVEMENT_SPEED))) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 10, 0.2, 0.2, 0.2, 0.1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getDirection()) == Direction.SOUTH) {
				sz = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextInt(RandomSource.create(), -15, -8);
				sx = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextInt(RandomSource.create(), -8, 8);
			} else if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getDirection()) == Direction.EAST) {
				sx = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextInt(RandomSource.create(), -15, -8);
				sz = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextInt(RandomSource.create(), -8, 8);
			} else if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getDirection()) == Direction.WEST) {
				sx = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextInt(RandomSource.create(), 8, 15);
				sz = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextInt(RandomSource.create(), -8, 8);
			} else {
				sz = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextInt(RandomSource.create(), 8, 15);
				sx = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextInt(RandomSource.create(), -8, 8);
			}
			if (world.getBlockState(BlockPos.containing(sx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) sx, (int) sz) - 1, sz)).canOcclude()) {
				{
					Entity _ent = entity;
					_ent.teleportTo(sx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) sx, (int) sz) + 1), sz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(sx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) sx, (int) sz) + 1), sz, _ent.getYRot(), _ent.getXRot());
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 5, false, true));
			}
		}
	}
}
