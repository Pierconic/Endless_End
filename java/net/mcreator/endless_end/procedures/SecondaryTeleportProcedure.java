package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
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
import net.minecraft.core.BlockPos;

public class SecondaryTeleportProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = x + Mth.nextInt(RandomSource.create(), -5, 5);
		sz = z + Mth.nextInt(RandomSource.create(), -5, 5);
		if (sz == 0 && sx == 0) {
			sz = z + 1;
		}
		sy = y;
		if (world.getBlockState(BlockPos.containing(sx, y - 1, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 0, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 1, sz)).canOcclude()) {
			sy = y + 0;
		} else if (world.getBlockState(BlockPos.containing(sx, y + 0, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 1, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 2, sz)).canOcclude()) {
			sy = y + 1;
		} else if (world.getBlockState(BlockPos.containing(sx, y + 1, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 2, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 3, sz)).canOcclude()) {
			sy = y + 2;
		} else if (world.getBlockState(BlockPos.containing(sx, y + 2, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 3, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 4, sz)).canOcclude()) {
			sy = y + 3;
		} else if (world.getBlockState(BlockPos.containing(sx, y + 3, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 4, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 5, sz)).canOcclude()) {
			sy = y + 4;
		} else if (world.getBlockState(BlockPos.containing(sx, y + 4, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 5, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 6, sz)).canOcclude()) {
			sy = y + 5;
		} else if (world.getBlockState(BlockPos.containing(sx, y + 5, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 6, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y + 7, sz)).canOcclude()) {
			sy = y + 6;
		} else if (world.getBlockState(BlockPos.containing(sx, y - 2, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y - 1, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y - 0, sz)).canOcclude()) {
			sy = y - 1;
		} else if (world.getBlockState(BlockPos.containing(sx, y - 3, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y - 2, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y - 1, sz)).canOcclude()) {
			sy = y - 2;
		} else if (world.getBlockState(BlockPos.containing(sx, y - 4, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y - 3, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y - 2, sz)).canOcclude()) {
			sy = y - 3;
		} else if (world.getBlockState(BlockPos.containing(sx, y - 5, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y - 4, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y - 3, sz)).canOcclude()) {
			sy = y - 4;
		} else if (world.getBlockState(BlockPos.containing(sx, y - 6, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y - 5, sz)).canOcclude() && !world.getBlockState(BlockPos.containing(sx, y - 4, sz)).canOcclude()) {
			sy = y - 5;
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:randomteleport")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:randomteleport")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 18, 0.3, 0.3, 0.3, 0.3);
		{
			Entity _ent = entity;
			_ent.teleportTo(sx, sy, sz);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(sx, sy, sz, _ent.getYRot(), _ent.getXRot());
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 1, false, false));
	}
}
