package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SprawlThornsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, String axis) {
		if (axis == null)
			return;
		if ((axis).equals("y")) {
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
				world.setBlock(BlockPos.containing(x + 1, y, z), (new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.GRIM_THORNS.get().defaultBlockState(), Direction.EAST)), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
				world.setBlock(BlockPos.containing(x - 1, y, z), (new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.GRIM_THORNS.get().defaultBlockState(), Direction.WEST)), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
				world.setBlock(BlockPos.containing(x, y, z - 1), (new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.GRIM_THORNS.get().defaultBlockState(), Direction.NORTH)), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
				world.setBlock(BlockPos.containing(x, y, z + 1), (new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.GRIM_THORNS.get().defaultBlockState(), Direction.SOUTH)), 3);
			}
		} else if ((axis).equals("x")) {
			if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.GRIM_THORNS.get().defaultBlockState(), Direction.UP)), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
				world.setBlock(BlockPos.containing(x, y - 1, z), (new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.GRIM_THORNS.get().defaultBlockState(), Direction.DOWN)), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
				world.setBlock(BlockPos.containing(x, y, z - 1), (new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.GRIM_THORNS.get().defaultBlockState(), Direction.NORTH)), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
				world.setBlock(BlockPos.containing(x, y, z + 1), (new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.GRIM_THORNS.get().defaultBlockState(), Direction.SOUTH)), 3);
			}
		} else if ((axis).equals("z")) {
			if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.GRIM_THORNS.get().defaultBlockState(), Direction.UP)), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
				world.setBlock(BlockPos.containing(x, y - 1, z), (new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.GRIM_THORNS.get().defaultBlockState(), Direction.DOWN)), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
				world.setBlock(BlockPos.containing(x + 1, y, z), (new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.GRIM_THORNS.get().defaultBlockState(), Direction.EAST)), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
				world.setBlock(BlockPos.containing(x - 1, y, z), (new Object() {
					public BlockState with(BlockState _bs, Direction newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
							return _bs.setValue(_dp, newValue);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
					}
				}.with(EndlessEndModBlocks.GRIM_THORNS.get().defaultBlockState(), Direction.WEST)), 3);
			}
		}
	}
}
