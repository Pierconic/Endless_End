package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class EssenceConversionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x + 1, y + 0, z + 0))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x + 1, y + 0, z + 0))).getBlock() == Blocks.WATER) {
			world.setBlock(BlockPos.containing(x + 1, y + 0, z + 0), Blocks.PACKED_ICE.defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.freeze")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.freeze")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index0 = 0; index0 < 15; index0++) {
				world.addParticle(ParticleTypes.FIREWORK, (x + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
						0.2, 0);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y + 0, z + 0))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x - 1, y + 0, z + 0))).getBlock() == Blocks.WATER) {
			world.setBlock(BlockPos.containing(x - 1, y + 0, z + 0), Blocks.PACKED_ICE.defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.freeze")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.freeze")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index1 = 0; index1 < 15; index1++) {
				world.addParticle(ParticleTypes.FIREWORK, (x - 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
						0.2, 0);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 0, y + 0, z + 1))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x - 0, y + 0, z + 1))).getBlock() == Blocks.WATER) {
			world.setBlock(BlockPos.containing(x - 0, y + 0, z + 1), Blocks.PACKED_ICE.defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.freeze")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.freeze")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index2 = 0; index2 < 15; index2++) {
				world.addParticle(ParticleTypes.FIREWORK, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
						0.2, 0);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 0, y + 0, z - 1))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x - 0, y + 0, z - 1))).getBlock() == Blocks.WATER) {
			world.setBlock(BlockPos.containing(x - 0, y + 0, z - 1), Blocks.PACKED_ICE.defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.freeze")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.freeze")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index3 = 0; index3 < 15; index3++) {
				world.addParticle(ParticleTypes.FIREWORK, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z - 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
						0.2, 0);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 0, y - 1, z - 0))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x - 0, y - 1, z - 0))).getBlock() == Blocks.WATER) {
			world.setBlock(BlockPos.containing(x - 0, y - 1, z - 0), Blocks.BLUE_ICE.defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.freeze")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.freeze")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index4 = 0; index4 < 15; index4++) {
				world.addParticle(ParticleTypes.FIREWORK, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
						0.2, 0);
			}
		} else if ((world.getBlockState(BlockPos.containing(x - 0, y + 1, z - 0))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x - 0, y + 1, z - 0))).getBlock() == Blocks.WATER) {
			world.setBlock(BlockPos.containing(x - 0, y + 1, z - 0), Blocks.ICE.defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.freeze")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.freeze")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index5 = 0; index5 < 15; index5++) {
				world.addParticle(ParticleTypes.FIREWORK, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 2.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
						0.2, 0);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y + 0, z + 0))).getBlock() == Blocks.LAVA || (world.getBlockState(BlockPos.containing(x + 1, y + 0, z + 0))).getBlock() == Blocks.LAVA) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index6 = 0; index6 < 15; index6++) {
				world.addParticle(ParticleTypes.FIREWORK, (x + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
						0.2, 0);
			}
			world.setBlock(BlockPos.containing(x + 1, y + 0, z + 0), Blocks.OBSIDIAN.defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y + 0, z + 0))).getBlock() == Blocks.LAVA || (world.getBlockState(BlockPos.containing(x - 1, y + 0, z + 0))).getBlock() == Blocks.LAVA) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index7 = 0; index7 < 15; index7++) {
				world.addParticle(ParticleTypes.FIREWORK, (x - 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
						0.2, 0);
			}
			world.setBlock(BlockPos.containing(x - 1, y + 0, z + 0), Blocks.OBSIDIAN.defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x - 0, y + 0, z + 1))).getBlock() == Blocks.LAVA || (world.getBlockState(BlockPos.containing(x - 0, y + 0, z + 1))).getBlock() == Blocks.LAVA) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index8 = 0; index8 < 15; index8++) {
				world.addParticle(ParticleTypes.FIREWORK, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
						0.2, 0);
			}
			world.setBlock(BlockPos.containing(x - 0, y + 0, z + 1), Blocks.OBSIDIAN.defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x - 0, y + 0, z - 1))).getBlock() == Blocks.LAVA || (world.getBlockState(BlockPos.containing(x - 0, y + 0, z - 1))).getBlock() == Blocks.LAVA) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index9 = 0; index9 < 15; index9++) {
				world.addParticle(ParticleTypes.FIREWORK, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z - 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
						0.2, 0);
			}
			world.setBlock(BlockPos.containing(x - 0, y + 0, z - 1), Blocks.OBSIDIAN.defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x - 0, y - 1, z - 0))).getBlock() == Blocks.LAVA || (world.getBlockState(BlockPos.containing(x - 0, y - 1, z - 0))).getBlock() == Blocks.LAVA) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int index10 = 0; index10 < 15; index10++) {
				world.addParticle(ParticleTypes.FIREWORK, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
						0.2, 0);
			}
			world.setBlock(BlockPos.containing(x - 0, y - 1, z - 0), Blocks.OBSIDIAN.defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x - 0, y + 1, z - 0))).getBlock() == Blocks.LAVA || (world.getBlockState(BlockPos.containing(x - 0, y + 1, z - 0))).getBlock() == Blocks.LAVA) {
			if ((world.getBlockState(BlockPos.containing(x - 0, y + 0, z - 0))).getFluidState().isSource()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.solidify")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:ether.solidify")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				for (int index11 = 0; index11 < 15; index11++) {
					world.addParticle(ParticleTypes.FIREWORK, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
							0.2, 0);
				}
				world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.ADAMANT.get().defaultBlockState(), 3);
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				for (int index12 = 0; index12 < 15; index12++) {
					world.addParticle(ParticleTypes.FIREWORK, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
							0.2, 0);
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.CALCITE.defaultBlockState(), 3);
			}
		}
	}
}
