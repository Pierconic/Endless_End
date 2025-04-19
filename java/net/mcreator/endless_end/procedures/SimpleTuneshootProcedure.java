package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SimpleTuneshootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, boolean vertical) {
		String face = "";
		double ox = 0;
		double oy = 0;
		double oz = 0;
		if (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() && vertical) {
				world.setBlock(BlockPos.containing(x, y, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "face", "floor")), 3);
				SimpleTuneshootProcedure.execute(world, x, y, z, vertical);
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
				SimpleTuneshootProcedure.execute(world, x, y, z, vertical);
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
				SimpleTuneshootProcedure.execute(world, x, y, z, vertical);
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
				SimpleTuneshootProcedure.execute(world, x, y, z, vertical);
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
				SimpleTuneshootProcedure.execute(world, x, y, z, vertical);
			}
		} else {
			face = ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep25 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep25).toString() : "")
					.toLowerCase();
			oy = 0;
			oz = 0;
			ox = 0;
			if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep27 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep27).toString() : "")
					.equals("FLOOR")) {
				oy = 1;
			} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep29 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep29).toString() : "")
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
				if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip43
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip43)
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
						SimpleTuneshootProcedure.execute(world, x, y + oy, z, vertical);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip50
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip50)
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
						SimpleTuneshootProcedure.execute(world, x, y + oy, z, vertical);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip56
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip56)
						: -1) == 2) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + oy, z))) {
						if (Math.random() < 0.3
								|| ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip59
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip59)
										: -1) >= 19
								|| ((world.getBlockState(BlockPos.containing(x, y - 3 * oy, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip61
										? (world.getBlockState(BlockPos.containing(x, y - 3 * oy, z))).getValue(_getip61)
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
							SimpleTuneshootProcedure.execute(world, x, y + oy, z, vertical);
						} else if (Math.random() < 0.4
								&& !(((world.getBlockState(BlockPos.containing(x, y - oy, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip66
										? (world.getBlockState(BlockPos.containing(x, y - oy, z))).getValue(_getip66)
										: -1) == 4)
								|| Math.random() < 0.1
								|| ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip68
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip68)
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
							SimpleTuneshootProcedure.execute(world, x, y + oy, z, vertical);
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
							SimpleTuneshootProcedure.execute(world, x, y + oy, z, vertical);
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
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip77
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip77)
						: -1) == 3) {
					{
						int _value = 2;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip80
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip80)
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
								int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip96
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip96)
										: -1) + 1);
								BlockPos _pos = BlockPos.containing(x - 1, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip99
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip99)
										: -1) + 1);
								BlockPos _pos = BlockPos.containing(x + 1, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							SimpleTuneshootProcedure.execute(world, x - 1, y, z, vertical);
							SimpleTuneshootProcedure.execute(world, x + 1, y, z, vertical);
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
								int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip116
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip116)
										: -1) + 1);
								BlockPos _pos = BlockPos.containing(x, y, z - 1);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip119
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip119)
										: -1) + 1);
								BlockPos _pos = BlockPos.containing(x, y, z + 1);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							SimpleTuneshootProcedure.execute(world, x, y, z + 1, vertical);
							SimpleTuneshootProcedure.execute(world, x, y, z - 1, vertical);
						}
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip122
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip122)
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
						SimpleTuneshootProcedure.execute(world, x, y + oy, z, vertical);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip128
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip128)
						: -1) == 7) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + oy, z))) {
						if (Math.random() < 0.3
								|| ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip131
										? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip131)
										: -1) >= 19
								|| ((world.getBlockState(BlockPos.containing(x, y - oy, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip133
										? (world.getBlockState(BlockPos.containing(x, y - oy, z))).getValue(_getip133)
										: -1) <= 3
										&& ((world.getBlockState(BlockPos.containing(x, y - oy * 2, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip135
												? (world.getBlockState(BlockPos.containing(x, y - oy * 2, z))).getValue(_getip135)
												: -1) <= 3) {
							world.setBlock(BlockPos.containing(x, y + oy, z), (new Object() {
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
							}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 10)), Direction.getRandom(RandomSource.create()))), "face", face)), 3);
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
							SimpleTuneshootProcedure.execute(world, x, y + oy, z, vertical);
						}
					}
				}
			} else {
				if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip145
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip145)
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
						SimpleTuneshootProcedure.execute(world, x + ox, y, z + oz, vertical);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip155
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip155)
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
						SimpleTuneshootProcedure.execute(world, x + ox, y, z + oz, vertical);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip164
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip164)
						: -1) == 2) {
					if (world.isEmptyBlock(BlockPos.containing(x + ox, y, z + oz))) {
						if (Math.random() < 0.25 || ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip167
								? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip167)
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
							SimpleTuneshootProcedure.execute(world, x + ox, y, z + oz, vertical);
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
							SimpleTuneshootProcedure.execute(world, x + ox, y, z + oz, vertical);
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
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip182
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip182)
						: -1) == 3) {
					{
						int _value = 2;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip185
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip185)
						: -1) == 7) {
					if (world.isEmptyBlock(BlockPos.containing(x + ox, y, z + oz))) {
						if (Math.random() < 0.8 || ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip188
								? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip188)
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
							}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))))), "blockstate", 10)), "face", face)), 3);
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
							SimpleTuneshootProcedure.execute(world, x + ox, y, z + oz, vertical);
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
				}
			}
			{
				int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip203
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip203)
						: -1) + 1);
				BlockPos _pos = BlockPos.containing(x + ox, y + oy, z + oz);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
	}
}
