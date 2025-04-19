package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;
import net.mcreator.endless_end.init.EndlessEndModEntities;
import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class TrawlerDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EndlessEndModEntities.GRAZER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement((entity.getLookAngle().x * (-1)), 0, (entity.getLookAngle().z * (-1)));
				}
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sniffer_egg.hatch")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sniffer_egg.hatch")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.CANTICLE_SPORE.get()), x, y, z, 30, 1, 1, 1, 0.3);
		world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.MOLDERING_PURPUR.get().defaultBlockState()));
		world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(EndlessEndModBlocks.MOLDERING_PURPUR.get().defaultBlockState()));
		world.levelEvent(2001, BlockPos.containing(x + 1, y, z), Block.getId(EndlessEndModBlocks.MOLDERING_PURPUR.get().defaultBlockState()));
		world.levelEvent(2001, BlockPos.containing(x, y, z + 1), Block.getId(EndlessEndModBlocks.MOLDERING_PURPUR.get().defaultBlockState()));
		world.levelEvent(2001, BlockPos.containing(x - 1, y, z), Block.getId(EndlessEndModBlocks.MOLDERING_PURPUR.get().defaultBlockState()));
		world.levelEvent(2001, BlockPos.containing(x, y, z - 1), Block.getId(EndlessEndModBlocks.MOLDERING_PURPUR.get().defaultBlockState()));
	}
}
