package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.EndlessEndMod;

public class SingingSandSpreadProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (1 < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip2 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip2) : -1)) {
			if (((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.SINGING_SAND.get() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.SPIRALING_SAND.get())
					&& ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip8
							? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getip8)
							: -1) < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip10
									? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip10)
									: -1) - 1) {
				{
					int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip12
							? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip12)
							: -1) - 1);
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				{
					int _value = (int) (((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip15
							? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getip15)
							: -1) + 1);
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			EndlessEndMod.queueServerWork(1, () -> {
				if (1 < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip19
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip19)
						: -1)) {
					if (((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EndlessEndModBlocks.SINGING_SAND.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EndlessEndModBlocks.SPIRALING_SAND.get())
							&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip25
									? (world.getBlockState(BlockPos.containing(x, y - 1, z))).getValue(_getip25)
									: -1) < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip27
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip27)
											: -1) - 1) {
						{
							int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip29
									? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip29)
									: -1) - 1);
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						{
							int _value = (int) (((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip32
									? (world.getBlockState(BlockPos.containing(x, y - 1, z))).getValue(_getip32)
									: -1) + 1);
							BlockPos _pos = BlockPos.containing(x, y - 1, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				}
			});
			EndlessEndMod.queueServerWork(2, () -> {
				if (1 < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip37
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip37)
						: -1)) {
					if (((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == EndlessEndModBlocks.SINGING_SAND.get() || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == EndlessEndModBlocks.SPIRALING_SAND.get())
							&& ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip43
									? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getip43)
									: -1) < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip45
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip45)
											: -1) - 1) {
						{
							int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip47
									? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip47)
									: -1) - 1);
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						{
							int _value = (int) (((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip50
									? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getip50)
									: -1) + 1);
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				}
			});
			EndlessEndMod.queueServerWork(3, () -> {
				if (1 < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip55
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip55)
						: -1)) {
					if (((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == EndlessEndModBlocks.SINGING_SAND.get() || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == EndlessEndModBlocks.SPIRALING_SAND.get())
							&& ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip61
									? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getip61)
									: -1) < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip63
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip63)
											: -1) - 1) {
						{
							int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip65
									? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip65)
									: -1) - 1);
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						{
							int _value = (int) (((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip68
									? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getip68)
									: -1) + 1);
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				}
			});
			EndlessEndMod.queueServerWork(4, () -> {
				if (1 < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip73
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip73)
						: -1)) {
					if (((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == EndlessEndModBlocks.SINGING_SAND.get() || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == EndlessEndModBlocks.SPIRALING_SAND.get())
							&& ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip79
									? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getip79)
									: -1) < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip81
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip81)
											: -1) - 1) {
						{
							int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip83
									? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip83)
									: -1) - 1);
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						{
							int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip86
									? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getip86)
									: -1) + 1);
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				}
			});
			EndlessEndMod.queueServerWork(5, () -> {
				if (1 < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip91
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip91)
						: -1)) {
					if (((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == EndlessEndModBlocks.SINGING_SAND.get() || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == EndlessEndModBlocks.SPIRALING_SAND.get())
							&& ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip97
									? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getip97)
									: -1) < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip99
											? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip99)
											: -1) - 1) {
						{
							int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip101
									? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip101)
									: -1) - 1);
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						{
							int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip104
									? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getip104)
									: -1) + 1);
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("particle.soul_escape")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				}
			});
		}
	}
}
