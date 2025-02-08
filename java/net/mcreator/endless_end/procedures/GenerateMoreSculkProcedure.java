package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.EndlessEndMod;

public class GenerateMoreSculkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		EndlessEndMod.queueServerWork(5, () -> {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:sculk_replaceable")))) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.SCULK.defaultBlockState(), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk.place")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk.place")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SCULK_SOUL, x, y, z, 12, 0.3, 0.3, 0.3, 0.1);
			}
			if (Math.random() < 0.65) {
				VeinPlacementProcedure.execute(world, x + 1, y, z);
			}
			if (Math.random() < 0.65) {
				VeinPlacementProcedure.execute(world, x - 1, y, z);
			}
			if (Math.random() < 0.65) {
				VeinPlacementProcedure.execute(world, x, y, z - 1);
			}
			if (Math.random() < 0.65) {
				VeinPlacementProcedure.execute(world, x, y, z + 1);
			}
			if (Math.random() < 0.65) {
				VeinPlacementProcedure.execute(world, x, y + 1, z);
			}
			if (Math.random() < 0.65) {
				VeinPlacementProcedure.execute(world, x, y - 1, z);
			}
		});
	}
}
