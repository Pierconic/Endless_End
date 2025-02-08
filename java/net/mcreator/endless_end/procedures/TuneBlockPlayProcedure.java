package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class TuneBlockPlayProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		boolean success = false;
		double level = 0;
		double sx = 0;
		double sz = 0;
		double sy = 0;
		double volume = 0;
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 0
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) == 13) {
			level = 1;
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5 ? blockstate.getValue(_getip5) : -1) == 1
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip7 ? blockstate.getValue(_getip7) : -1) == 14) {
			level = 1.0595;
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip9 ? blockstate.getValue(_getip9) : -1) == 2
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip11 ? blockstate.getValue(_getip11) : -1) == 15) {
			level = 1.12246;
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13 ? blockstate.getValue(_getip13) : -1) == 3
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip15 ? blockstate.getValue(_getip15) : -1) == 16) {
			level = 1.18921;
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip17 ? blockstate.getValue(_getip17) : -1) == 4
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip19 ? blockstate.getValue(_getip19) : -1) == 17) {
			level = 1.25992;
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip21 ? blockstate.getValue(_getip21) : -1) == 5
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip23 ? blockstate.getValue(_getip23) : -1) == 18) {
			level = 1.33485;
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip25 ? blockstate.getValue(_getip25) : -1) == 6
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip27 ? blockstate.getValue(_getip27) : -1) == 19) {
			level = 1.41421;
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip29 ? blockstate.getValue(_getip29) : -1) == 7
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip31 ? blockstate.getValue(_getip31) : -1) == 20) {
			level = 1.49831;
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip33 ? blockstate.getValue(_getip33) : -1) == 8
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip35 ? blockstate.getValue(_getip35) : -1) == 21) {
			level = 1.5874;
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip37 ? blockstate.getValue(_getip37) : -1) == 9
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip39 ? blockstate.getValue(_getip39) : -1) == 22) {
			level = 1.68179;
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip41 ? blockstate.getValue(_getip41) : -1) == 10
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip43 ? blockstate.getValue(_getip43) : -1) == 23) {
			level = 1.7818;
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip45 ? blockstate.getValue(_getip45) : -1) == 11
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip47 ? blockstate.getValue(_getip47) : -1) == 24) {
			level = 1.88775;
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip49 ? blockstate.getValue(_getip49) : -1) == 12
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip51 ? blockstate.getValue(_getip51) : -1) == 25) {
			level = 2;
		}
		sx = 0;
		sy = 0;
		sz = 0;
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.DOWN) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.NOTE, (x + 0.5), (y - 0.5), (z + 0.5), 1, 0.1, 0.1, 0.1, 0.1);
			sy = 1;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.UP) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.NOTE, (x + 0.5), (y + 1.5), (z + 0.5), 1, 0.1, 0.1, 0.1, 0.1);
			sy = -1;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.EAST) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.NOTE, (x + 1.5), (y + 0.5), (z + 0.5), 1, 0.1, 0.1, 0.1, 0.1);
			sx = -1;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.WEST) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.NOTE, (x - 0.5), (y + 0.5), (z + 0.5), 1, 0.1, 0.1, 0.1, 0.1);
			sx = 1;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.NORTH) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.NOTE, (x + 0.5), (y + 0.5), (z - 0.5), 1, 0.1, 0.1, 0.1, 0.1);
			sz = 1;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.SOUTH) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.NOTE, (x + 0.5), (y + 0.5), (z + 1.5), 1, 0.1, 0.1, 0.1, 0.1);
			sz = -1;
		}
		volume = 1;
		if ((world.getBlockState(BlockPos.containing(x + 1, y + 0, z + 0))).is(BlockTags.create(ResourceLocation.parse("minecraft:dampens_vibrations")))) {
			volume = volume - 0.25;
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y + 0, z + 0))).is(BlockTags.create(ResourceLocation.parse("minecraft:dampens_vibrations")))) {
			volume = volume - 0.25;
		}
		if ((world.getBlockState(BlockPos.containing(x - 0, y + 0, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:dampens_vibrations")))) {
			volume = volume - 0.25;
		}
		if ((world.getBlockState(BlockPos.containing(x - 0, y + 0, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:dampens_vibrations")))) {
			volume = volume - 0.25;
		}
		if ((world.getBlockState(BlockPos.containing(x - 0, y + 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:dampens_vibrations")))) {
			volume = volume - 0.25;
		}
		if ((world.getBlockState(BlockPos.containing(x - 0, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:dampens_vibrations")))) {
			volume = volume - 0.25;
		}
		if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_bamboo")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.bamboo")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.bamboo")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_wooden")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.wood")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.wood")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_ghost")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.ghost")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.ghost")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_ice")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.ice")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.ice")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_terracotta")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.terracotta")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.terracotta")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_glazed")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.glazed_terracotta")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.glazed_terracotta")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_end")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.glazed_terracotta")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.glazed_terracotta")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_prism")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.prism")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.prism")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_dark")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.dark_prism")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.dark_prism")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_magma")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.magma")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.magma")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_copper")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.copper")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.copper")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_iron")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.iron")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.iron")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_gold")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.gold")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.gold")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_emerald")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.emerald")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.emerald")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_lapis")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.lapis")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.lapis")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_amethyst")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.amethyst")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.amethyst")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_obsidian")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.obsidian")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.obsidian")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_adamant")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.adamant")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.adamant")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_stone")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.stone")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.stone")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_deepslate")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.deepslate")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.deepslate")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_netherite")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.netherite")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.netherite")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.flute")), SoundSource.RECORDS, (float) volume, (float) level);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:tune.flute")), SoundSource.RECORDS, (float) volume, (float) level, false);
				}
			}
		}
	}
}
