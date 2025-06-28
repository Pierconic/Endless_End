package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class FlouriteLightSpreadProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double hue = 0;
		boolean success = false;
		success = false;
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.FLOURITE.get() && !((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3
				? blockstate.getValue(_getip3)
				: -1) == ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5
						? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getip5)
						: -1))) {
			world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip7 ? blockstate.getValue(_getip7) : -1)), 3);
			success = true;
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EndlessEndModBlocks.FLOURITE.get() && !((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13
				? blockstate.getValue(_getip13)
				: -1) == ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip15
						? (world.getBlockState(BlockPos.containing(x, y - 1, z))).getValue(_getip15)
						: -1))) {
			world.setBlock(BlockPos.containing(x, y - 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip17 ? blockstate.getValue(_getip17) : -1)), 3);
			success = true;
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == EndlessEndModBlocks.FLOURITE.get() && !((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip23
				? blockstate.getValue(_getip23)
				: -1) == ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip25
						? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getip25)
						: -1))) {
			world.setBlock(BlockPos.containing(x + 1, y, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip27 ? blockstate.getValue(_getip27) : -1)), 3);
			success = true;
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == EndlessEndModBlocks.FLOURITE.get() && !((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip33
				? blockstate.getValue(_getip33)
				: -1) == ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip35
						? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getip35)
						: -1))) {
			world.setBlock(BlockPos.containing(x - 1, y, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip37 ? blockstate.getValue(_getip37) : -1)), 3);
			success = true;
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == EndlessEndModBlocks.FLOURITE.get() && !((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip43
				? blockstate.getValue(_getip43)
				: -1) == ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip45
						? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getip45)
						: -1))) {
			world.setBlock(BlockPos.containing(x, y, z + 1), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip47 ? blockstate.getValue(_getip47) : -1)), 3);
			success = true;
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == EndlessEndModBlocks.FLOURITE.get() && !((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip53
				? blockstate.getValue(_getip53)
				: -1) == ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip55
						? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getip55)
						: -1))) {
			world.setBlock(BlockPos.containing(x, y, z - 1), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip57 ? blockstate.getValue(_getip57) : -1)), 3);
			success = true;
		}
		if (!success) {
			world.setBlock(BlockPos.containing(x, y, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.FLOURITE.get().defaultBlockState(), "blockstate", blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip61 ? blockstate.getValue(_getip61) : -1)), 3);
		}
	}
}
