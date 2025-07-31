package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class StrangeEggsAdvanceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, boolean provoked) {
		double chance = 0;
		boolean success = false;
		boolean hatch = false;
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip1) : -1) < 8) {
			{
				int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip3)
						: -1) + 4);
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:strange_egg_crack")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:strange_egg_crack")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		} else {
			if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip7 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip7) : -1) == 8) {
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.STRANGE_EGGS.get().defaultBlockState()));
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:strange_egg.hatch")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:strange_egg.hatch")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip12
					? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip12)
					: -1) == 9) {
				for (int index0 = 0; index0 < 2; index0++) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.STRANGE_EGGS.get().defaultBlockState()));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:strange_egg.hatch")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:strange_egg.hatch")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip17
					? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip17)
					: -1) == 10) {
				for (int index1 = 0; index1 < 3; index1++) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.STRANGE_EGGS.get().defaultBlockState()));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:strange_egg.hatch")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:strange_egg.hatch")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip22
					? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip22)
					: -1) == 11) {
				for (int index2 = 0; index2 < 4; index2++) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.STRANGE_EGGS.get().defaultBlockState()));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:strange_egg.hatch")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:strange_egg.hatch")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if (provoked) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.STRANGE_EGGS.get().defaultBlockState()));
			} else {
				{
					int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip29
							? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip29)
							: -1) + 4);
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			}
		}
	}
}
