package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SimpleTuneshootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String face = "";
		double ox = 0;
		double oy = 0;
		double oz = 0;
		if (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
				world.setBlock(BlockPos.containing(x, y, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "face", "floor")), 3);
				SimpleTuneshootProcedure.execute(world, x, y, z);
			} else if (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
				world.setBlock(BlockPos.containing(x, y, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "face", "ceiling")), 3);
				SimpleTuneshootProcedure.execute(world, x, y, z);
			} else if (world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude()) {
				world.setBlock(BlockPos.containing(x, y, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with((new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with((new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), Direction.WEST)), "blockstate", 0)), "face", "WALL")), 3);
				SimpleTuneshootProcedure.execute(world, x, y, z);
			} else if (world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude()) {
				world.setBlock(BlockPos.containing(x, y, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with((new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with((new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), Direction.EAST)), "blockstate", 0)), "face", "WALL")), 3);
				SimpleTuneshootProcedure.execute(world, x, y, z);
			} else if (world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude()) {
				world.setBlock(BlockPos.containing(x, y, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with((new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with((new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), Direction.NORTH)), "blockstate", 0)), "face", "WALL")), 3);
				SimpleTuneshootProcedure.execute(world, x, y, z);
			} else if (world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude()) {
				world.setBlock(BlockPos.containing(x, y, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with((new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with((new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), Direction.SOUTH)), "blockstate", 0)), "face", "WALL")), 3);
				SimpleTuneshootProcedure.execute(world, x, y, z);
			}
		} else {
			face = ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep28 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep28).toString() : "")
					.toLowerCase();
			oy = 0;
			oz = 0;
			ox = 0;
			if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep30 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep30).toString() : "")
					.equals("FLOOR")) {
				oy = 1;
			} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep32 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep32).toString() : "")
					.equals("CEILING")) {
				oy = -1;
			} else {
				if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.NORTH) {
					oz = -1;
				} else if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.SOUTH) {
					oz = 1;
				} else if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.EAST) {
					ox = 1;
				} else if ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.WEST) {
					ox = -1;
				}
			}
			if (oy != 0) {
				if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip46
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip46)
						: -1) == 0) {
					{
						int _value = 11;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (world.isEmptyBlock(BlockPos.containing(x, y + oy, z))) {
						world.setBlock(BlockPos.containing(x, y + oy, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 1)), "face", face)), 3);
						SimpleTuneshootProcedure.execute(world, x, y + oy, z);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip53
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip53)
						: -1) == 1) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + oy, z))) {
						world.setBlock(BlockPos.containing(x, y + oy, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 2)), "face", face)), 3);
						SimpleTuneshootProcedure.execute(world, x, y + oy, z);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip59
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip59)
						: -1) == 2) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + oy, z))) {
						if (Math.random() < 0.3
								|| ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip62
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip62)
										: -1) >= 19
								|| ((world.getBlockState(BlockPos.containing(x, y - 3 * oy, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip64
										? (world.getBlockState(BlockPos.containing(x, y - 3 * oy, z))).getValue(_getip64)
										: -1) == 4) {
							world.setBlock(BlockPos.containing(x, y + oy, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 7)), "face", face)), 3);
							SimpleTuneshootProcedure.execute(world, x, y + oy, z);
						} else if (Math.random() < 0.4
								&& !(((world.getBlockState(BlockPos.containing(x, y - oy, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip69
										? (world.getBlockState(BlockPos.containing(x, y - oy, z))).getValue(_getip69)
										: -1) == 4)
								|| Math.random() < 0.1
								|| ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip71
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip71)
										: -1) >= 19) {
							world.setBlock(BlockPos.containing(x, y + oy, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 5)), "face", face)), 3);
							SimpleTuneshootProcedure.execute(world, x, y + oy, z);
						} else {
							world.setBlock(BlockPos.containing(x, y + oy, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 2)), "face", face)), 3);
							SimpleTuneshootProcedure.execute(world, x, y + oy, z);
						}
					} else {
						{
							int _value = 3;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip80
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip80)
						: -1) == 3) {
					{
						int _value = 2;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip83
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip83)
						: -1) == 5) {
					if (Math.random() < 0.5) {
						if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 0, z)) && world.isEmptyBlock(BlockPos.containing(x - 1, y + 0, z))) {
							world.setBlock(BlockPos.containing(x, y, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), Direction.SOUTH)), "blockstate", 6)), "face", face)), 3);
							world.setBlock(BlockPos.containing(x + 1, y, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), Direction.EAST)), "blockstate", 4)), "face", face)), 3);
							world.setBlock(BlockPos.containing(x - 1, y, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), Direction.WEST)), "blockstate", 4)), "face", face)), 3);
							{
								int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip99
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip99)
										: -1) + 1);
								BlockPos _pos = BlockPos.containing(x - 1, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip102
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip102)
										: -1) + 1);
								BlockPos _pos = BlockPos.containing(x + 1, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							SimpleTuneshootProcedure.execute(world, x - 1, y, z);
							SimpleTuneshootProcedure.execute(world, x + 1, y, z);
						}
					} else {
						if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 0, z)) && world.isEmptyBlock(BlockPos.containing(x - 1, y + 0, z))) {
							world.setBlock(BlockPos.containing(x, y, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), Direction.EAST)), "blockstate", 6)), "face", face)), 3);
							world.setBlock(BlockPos.containing(x, y, z + 1), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), Direction.SOUTH)), "blockstate", 4)), "face", face)), 3);
							world.setBlock(BlockPos.containing(x, y, z - 1), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), Direction.NORTH)), "blockstate", 4)), "face", face)), 3);
							{
								int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip119
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip119)
										: -1) + 1);
								BlockPos _pos = BlockPos.containing(x, y, z - 1);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip122
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip122)
										: -1) + 1);
								BlockPos _pos = BlockPos.containing(x, y, z + 1);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							SimpleTuneshootProcedure.execute(world, x, y, z + 1);
							SimpleTuneshootProcedure.execute(world, x, y, z - 1);
						}
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip125
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip125)
						: -1) == 4) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + oy, z))) {
						world.setBlock(BlockPos.containing(x, y + oy, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 2)), "face", face)), 3);
						SimpleTuneshootProcedure.execute(world, x, y + oy, z);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip131
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip131)
						: -1) == 7) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + oy, z))) {
						if (Math.random() < 0.3
								|| ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip134
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip134)
										: -1) >= 19
								|| ((world.getBlockState(BlockPos.containing(x, y - oy, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip136
										? (world.getBlockState(BlockPos.containing(x, y - oy, z))).getValue(_getip136)
										: -1) <= 3
										&& ((world.getBlockState(BlockPos.containing(x, y - oy * 2, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip138
												? (world.getBlockState(BlockPos.containing(x, y - oy * 2, z))).getValue(_getip138)
												: -1) <= 3) {
							world.setBlock(BlockPos.containing(x, y + oy, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 9)), "face", face)), 3);
							SimpleTuneshootProcedure.execute(world, x, y + oy, z);
						} else {
							world.setBlock(BlockPos.containing(x, y + oy, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 7)), "face", face)), 3);
							SimpleTuneshootProcedure.execute(world, x, y + oy, z);
						}
					} else {
						{
							int _value = 8;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip147
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip147)
						: -1) == 8) {
					{
						int _value = 7;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip150
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip150)
						: -1) == 9) {
					if (Math.random() < 0.5) {
						world.setBlock(BlockPos.containing(x, y, z), (new Object() {
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
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 10)), Direction.NORTH)), "face", face)), 3);
					} else {
						world.setBlock(BlockPos.containing(x, y, z), (new Object() {
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
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 10)), Direction.WEST)), "face", face)), 3);
					}
				}
			} else {
				if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip160
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip160)
						: -1) == 0) {
					{
						int _value = 11;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (world.isEmptyBlock(BlockPos.containing(x + ox, y, z + oz))) {
						world.setBlock(BlockPos.containing(x + ox, y, z + oz), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), (new Object() {
							public Direction getDirection(BlockState _bs) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp)
									return _bs.getValue(_dp);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
										? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
										: Direction.NORTH;
							}
						}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))))), "blockstate", 1)), "face", face)), 3);
						SimpleTuneshootProcedure.execute(world, x + ox, y, z + oz);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip170
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip170)
						: -1) == 1) {
					if (world.isEmptyBlock(BlockPos.containing(x + ox, y, z + oz))) {
						world.setBlock(BlockPos.containing(x + ox, y, z + oz), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), (new Object() {
							public Direction getDirection(BlockState _bs) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp)
									return _bs.getValue(_dp);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
										? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
										: Direction.NORTH;
							}
						}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))))), "blockstate", 2)), "face", face)), 3);
						SimpleTuneshootProcedure.execute(world, x + ox, y, z + oz);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip179
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip179)
						: -1) == 2) {
					if (world.isEmptyBlock(BlockPos.containing(x + ox, y, z + oz))) {
						if (Math.random() < 0.25 || ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip182
								? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip182)
								: -1) >= 19) {
							world.setBlock(BlockPos.containing(x + ox, y, z + oz), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), (new Object() {
								public Direction getDirection(BlockState _bs) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp)
										return _bs.getValue(_dp);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
											? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
											: Direction.NORTH;
								}
							}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))))), "blockstate", 2)), "face", face)), 3);
						} else {
							world.setBlock(BlockPos.containing(x + ox, y, z + oz), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), (new Object() {
								public Direction getDirection(BlockState _bs) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp)
										return _bs.getValue(_dp);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
											? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
											: Direction.NORTH;
								}
							}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))))), "blockstate", 7)), "face", face)), 3);
						}
					} else {
						{
							int _value = 3;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip197
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip197)
						: -1) == 3) {
					{
						int _value = 2;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip200
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip200)
						: -1) == 7) {
					if (world.isEmptyBlock(BlockPos.containing(x + ox, y, z + oz))) {
						if (Math.random() < 0.5 || ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip203
								? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip203)
								: -1) >= 19) {
							world.setBlock(BlockPos.containing(x + ox, y, z + oz), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), (new Object() {
								public Direction getDirection(BlockState _bs) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp)
										return _bs.getValue(_dp);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
											? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
											: Direction.NORTH;
								}
							}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))))), "blockstate", 9)), "face", face)), 3);
						} else {
							world.setBlock(BlockPos.containing(x, y + oy, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with((new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), (new Object() {
								public Direction getDirection(BlockState _bs) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp)
										return _bs.getValue(_dp);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
											? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
											: Direction.NORTH;
								}
							}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))))), "blockstate", 7)), "face", face)), 3);
						}
					} else {
						{
							int _value = 8;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip218
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip218)
						: -1) == 8) {
					{
						int _value = 7;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip221
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip221)
						: -1) == 9) {
					{
						int _value = 10;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				}
			}
			{
				int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip224
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip224)
						: -1) + 1);
				BlockPos _pos = BlockPos.containing(x + ox, y + oy, z + oz);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
	}
}
