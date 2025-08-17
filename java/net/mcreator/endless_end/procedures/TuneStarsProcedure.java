package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class TuneStarsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double note, double vol) {
		boolean success = false;
		double level = 0;
		double sx = 0;
		double sz = 0;
		double sy = 0;
		double volume = 0;
		double status = 0;
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "lead")) {
			if (note == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_1")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_1")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_2")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_2")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 2) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_3")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_3")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 3) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_4")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_4")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 4) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_5")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_5")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 5) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_6")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_6")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 6) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_7")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_7")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 7) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_8")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_8")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 8) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_9")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_9")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 9) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_10")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_10")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 10) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_11")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_11")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 11) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_12")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_12")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 12) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_13")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lead_adamant_13")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("lead", false);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else {
			if (note == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_1")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_1")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_2")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_2")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 2) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_3")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_3")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 3) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_4")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_4")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 4) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_5")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_5")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 5) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_6")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_6")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 6) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_7")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_7")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 7) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_8")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_8")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 8) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_9")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_9")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 9) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_10")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_10")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 10) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_11")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_11")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 11) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_12")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_12")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			} else if (note == 12) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_13")), SoundSource.BLOCKS, (float) vol, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loop_adamant_13")), SoundSource.BLOCKS, (float) vol, 1, false);
					}
				}
			}
		}
	}
}
