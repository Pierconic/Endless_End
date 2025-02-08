package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class ShiftyEndoriteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double direction = 0;
		if (Math.random() < 0.5) {
			direction = Mth.nextInt(RandomSource.create(), 0, 5);
			if (direction == 0 && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.END_STONE) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.END_STONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y - 1, z), EndlessEndModBlocks.ENDORITE_ORE.get().defaultBlockState(), 3);
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.ENDORITE_ORE.get().defaultBlockState()));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endoritebreak")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endoritebreak")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 15, 0.4, 0.4, 0.4, 0.3);
			} else if (direction == 1 && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.END_STONE) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.END_STONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 1, z), EndlessEndModBlocks.ENDORITE_ORE.get().defaultBlockState(), 3);
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.ENDORITE_ORE.get().defaultBlockState()));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endoritebreak")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endoritebreak")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 15, 0.4, 0.4, 0.4, 0.3);
			} else if (direction == 2 && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.END_STONE) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.END_STONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z), EndlessEndModBlocks.ENDORITE_ORE.get().defaultBlockState(), 3);
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.ENDORITE_ORE.get().defaultBlockState()));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endoritebreak")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endoritebreak")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 15, 0.4, 0.4, 0.4, 0.3);
			} else if (direction == 3 && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.END_STONE) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.END_STONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z), EndlessEndModBlocks.ENDORITE_ORE.get().defaultBlockState(), 3);
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.ENDORITE_ORE.get().defaultBlockState()));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endoritebreak")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endoritebreak")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 15, 0.4, 0.4, 0.4, 0.3);
			} else if (direction == 4 && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.END_STONE) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.END_STONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z - 1), EndlessEndModBlocks.ENDORITE_ORE.get().defaultBlockState(), 3);
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.ENDORITE_ORE.get().defaultBlockState()));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endoritebreak")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endoritebreak")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 15, 0.4, 0.4, 0.4, 0.3);
			} else if (direction == 5 && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.END_STONE) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.END_STONE.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z + 1), EndlessEndModBlocks.ENDORITE_ORE.get().defaultBlockState(), 3);
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.ENDORITE_ORE.get().defaultBlockState()));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endoritebreak")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endoritebreak")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 15, 0.4, 0.4, 0.4, 0.3);
			}
		}
	}
}
