package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class VioletShootProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double sy = 0;
		double y_factor = 0;
		y_factor = 1;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:chorus_orchard"))) {
			y_factor = 2;
		}
		world.setBlock(BlockPos.containing(x, y - 1, z), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), (int) (2 * y_factor), (int) (7 * y_factor)); index0++) {
			world.setBlock(BlockPos.containing(x, y + sy, z), EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
			sy = sy + 1;
		}
		world.setBlock(BlockPos.containing(x, y + sy, z), (new Object() {
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
		sy = sy + 1;
		for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), (int) y_factor, (int) (2 * y_factor)); index1++) {
			world.setBlock(BlockPos.containing(x, y + sy, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with((new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 2)), "face", "floor")), 3);
			sy = sy + 1;
		}
		for (int index2 = 0; index2 < Mth.nextInt(RandomSource.create(), (int) y_factor, (int) (3 * y_factor)); index2++) {
			world.setBlock(BlockPos.containing(x, y + sy, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with((new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 7)), "face", "floor")), 3);
			sy = sy + 1;
		}
		world.setBlock(BlockPos.containing(x, y + sy, z), (new Object() {
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
		}.with((new Object() {
			public BlockState with(BlockState _bs, String _property, int _newValue) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
				return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
			}
		}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 10)), "face", "floor")), new Object() {
			public Direction getValue() {
				Direction _dir = Direction.NORTH;
				int _num = Mth.nextInt(RandomSource.create(), 1, 4);
				if (_num == 1) {
					_dir = Direction.EAST;
				} else if (_num == 2) {
					_dir = Direction.SOUTH;
				} else if (_num == 3) {
					_dir = Direction.WEST;
				}
				return _dir;
			}
		}.getValue())), 3);
		return true;
	}
}
