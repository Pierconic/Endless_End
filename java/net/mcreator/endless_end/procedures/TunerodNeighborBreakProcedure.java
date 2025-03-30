package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class TunerodNeighborBreakProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double oy = 0;
		double oz = 0;
		double ox = 0;
		oy = y;
		oz = z;
		ox = x;
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 4) {
			if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.WEST) {
				ox = x + 1;
			} else if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.EAST) {
				ox = x - 1;
			} else if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.NORTH) {
				oz = z + 1;
			} else {
				oz = z - 1;
			}
		} else {
			if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep12 ? blockstate.getValue(_getep12).toString() : "").equals("FLOOR")) {
				oy = y - 1;
			} else if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep14 ? blockstate.getValue(_getep14).toString() : "").equals("CEILING")) {
				oy = y + 1;
			} else if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep16 ? blockstate.getValue(_getep16).toString() : "").equals("WALL")) {
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
				}.getDirection(blockstate)) == Direction.WEST) {
					ox = x + 1;
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
				}.getDirection(blockstate)) == Direction.EAST) {
					ox = x - 1;
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
				}.getDirection(blockstate)) == Direction.NORTH) {
					oz = z + 1;
				} else {
					oz = z - 1;
				}
			}
		}
		if (!((world.getBlockState(BlockPos.containing(ox, oy, oz))).getBlock() == EndlessEndModBlocks.TUNEROD_STEM.get()
				&& ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep29 ? blockstate.getValue(_getep29).toString() : "")
						.equals((world.getBlockState(BlockPos.containing(ox, oy, oz))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep31
								? (world.getBlockState(BlockPos.containing(ox, oy, oz))).getValue(_getep31).toString()
								: "")
						&& ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep33 ? blockstate.getValue(_getep33).toString() : "").equals("FLOOR")
								|| (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep35 ? blockstate.getValue(_getep35).toString() : "").equals("CEILING"))
						|| (new Object() {
							public Direction getDirection(BlockState _bs) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp)
									return _bs.getValue(_dp);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
										? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
										: Direction.NORTH;
							}
						}.getDirection(blockstate)) == (new Object() {
							public Direction getDirection(BlockPos pos) {
								BlockState _bs = world.getBlockState(pos);
								Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (property != null && _bs.getValue(property) instanceof Direction _dir)
									return _dir;
								else if (_bs.hasProperty(BlockStateProperties.AXIS))
									return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
								else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
									return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
								return Direction.NORTH;
							}
						}.getDirection(BlockPos.containing(x, y, z))) && (blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep41 ? blockstate.getValue(_getep41).toString() : "").equals("WALL"))
				|| world.getBlockState(BlockPos.containing(ox, oy, oz)).canOcclude())) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}
