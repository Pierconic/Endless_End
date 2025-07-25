package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;

import com.mojang.blaze3d.platform.InputConstants;

public class LoomerLaunchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double repeats = 0;
		entity.fallDistance = 0;
		if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_SPACE)) {
			if (entity.getDeltaMovement().y() <= 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:moon_jump")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:moon_jump")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 1.7, (entity.getDeltaMovement().z())));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.MOON_SPLAT.get()), (x + 0.5), (y + 1.5), (z + 0.5), 14, 0.2, 0.2, 0.2, 0.35);
			repeats = 0;
		} else {
			if (entity.getDeltaMovement().y() <= 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:moon_bounce")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:moon_bounce")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 1, (entity.getDeltaMovement().z())));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.MOON_SPLAT.get()), (x + 0.5), (y + 1.5), (z + 0.5), 8, 0.2, 0.2, 0.2, 0.1);
		}
		world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.MOON_BLOB.get()), (entity.getX()), (entity.getY() + 0.5), (entity.getZ()), 0, 0.2, 0);
		repeats = repeats + 1;
	}
}
