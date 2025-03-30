package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModItems;
import net.mcreator.endless_end.init.EndlessEndModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TunerodPlacementProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getFace(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Direction direction, Entity entity) {
		execute(null, world, x, y, z, blockstate, direction, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Direction direction, Entity entity) {
		if (direction == null || entity == null)
			return;
		boolean success = false;
		success = false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EndlessEndModItems.TUNE_ROD.get()) {
			if (blockstate.is(BlockTags.create(ResourceLocation.parse("forge:tunerod_growable")))) {
				if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && direction == Direction.UP) {
					world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with((new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "face", "floor")), Direction.UP)), 3);
					success = true;
				} else if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z)) && direction == Direction.DOWN) {
					world.setBlock(BlockPos.containing(x, y - 1, z), (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with((new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "face", "ceiling")), Direction.DOWN)), 3);
					success = true;
				} else if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) && direction == Direction.NORTH) {
					world.setBlock(BlockPos.containing(x, y, z - 1), (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with((new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "face", "wall")), Direction.NORTH)), 3);
				} else if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1)) && direction == Direction.SOUTH) {
					world.setBlock(BlockPos.containing(x, y, z + 1), (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with((new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "face", "wall")), Direction.SOUTH)), 3);
					success = true;
				} else if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z)) && direction == Direction.WEST) {
					world.setBlock(BlockPos.containing(x - 1, y, z), (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with((new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "face", "wall")), Direction.WEST)), 3);
					success = true;
				} else if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z)) && direction == Direction.EAST) {
					world.setBlock(BlockPos.containing(x + 1, y, z), (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with((new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "face", "wall")), Direction.EAST)), 3);
					success = true;
				}
			} else if (blockstate.getBlock() == EndlessEndModBlocks.TUNEROD_STEM.get()) {
				if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep38 ? blockstate.getValue(_getep38).toString() : "").equals("FLOOR")) {
					{
						int _value = 11;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with((new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 11)), "face", "floor")), 3);
					success = true;
				} else if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z)) && (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep45 ? blockstate.getValue(_getep45).toString() : "").equals("CEILING")) {
					{
						int _value = 11;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					world.setBlock(BlockPos.containing(x, y - 1, z), (new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with((new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 11)), "face", "ceiling")), 3);
					success = true;
				} else if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep51 ? blockstate.getValue(_getep51).toString() : "").equals("WALL")) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) && (new Object() {
						public Direction getDirection(BlockState _bs) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp)
								return _bs.getValue(_dp);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
									? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
									: Direction.NORTH;
						}
					}.getDirection(blockstate)) == Direction.NORTH) {
						{
							int _value = 11;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						world.setBlock(BlockPos.containing(x, y, z - 1), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 11)), Direction.NORTH)), "face", "wall")), 3);
						success = true;
					} else if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1)) && (new Object() {
						public Direction getDirection(BlockState _bs) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp)
								return _bs.getValue(_dp);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
									? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
									: Direction.NORTH;
						}
					}.getDirection(blockstate)) == Direction.SOUTH) {
						{
							int _value = 11;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						world.setBlock(BlockPos.containing(x, y, z + 1), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 11)), Direction.SOUTH)), "face", "wall")), 3);
						success = true;
					} else if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z)) && (new Object() {
						public Direction getDirection(BlockState _bs) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp)
								return _bs.getValue(_dp);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
									? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
									: Direction.NORTH;
						}
					}.getDirection(blockstate)) == Direction.EAST) {
						{
							int _value = 11;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						world.setBlock(BlockPos.containing(x + 1, y, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 11)), Direction.EAST)), "face", "wall")), 3);
						success = true;
					} else if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z)) && (new Object() {
						public Direction getDirection(BlockState _bs) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp)
								return _bs.getValue(_dp);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
									? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
									: Direction.NORTH;
						}
					}.getDirection(blockstate)) == Direction.WEST) {
						{
							int _value = 11;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						world.setBlock(BlockPos.containing(x - 1, y, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 11)), Direction.WEST)), "face", "wall")), 3);
						success = true;
					}
				}
			}
		}
		if (success) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bamboo_wood.place")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bamboo_wood.place")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			}
		}
	}
}
