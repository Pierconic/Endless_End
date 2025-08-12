package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class RandWarpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double range) {
		if (entity == null)
			return;
		double xOff = 0;
		double zOff = 0;
		double jump = 0;
		double distance = 0;
		double sy = 0;
		boolean found = false;
		xOff = Mth.nextInt(RandomSource.create(), (int) (range * (-1)), (int) range);
		zOff = Mth.nextInt(RandomSource.create(), (int) (range * (-1)), (int) range);
		sy = range * 0.5;
		found = false;
		for (int index0 = 0; index0 < 20; index0++) {
			if (!found) {
				if (world.getBlockFloorHeight(BlockPos.containing(x + xOff, y + sy, z + zOff)) > 0) {
					found = true;
				} else {
					sy = sy - 1;
				}
			}
		}
		if (found) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x + xOff, y + sy + 1, z + zOff), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((x + xOff), (y + sy + 1), (z + zOff), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 20, 0.6, 0.6, 0.6, 0.1);
			{
				Entity _ent = entity;
				_ent.teleportTo((x + xOff), (y + sy + 1), (z + zOff));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((x + xOff), (y + sy + 1), (z + zOff), _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}
