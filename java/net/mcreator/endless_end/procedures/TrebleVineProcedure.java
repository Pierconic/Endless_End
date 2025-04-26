package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class TrebleVineProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double sy = 0;
		double y_factor = 0;
		y_factor = 1;
		world.setBlock(BlockPos.containing(x, y - 1, z), EndlessEndModBlocks.ROTTING_END_STONE.get().defaultBlockState(), 3);
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), (int) (2 * y_factor), (int) (7 * y_factor)); index0++) {
			if (world.isEmptyBlock(BlockPos.containing(x, y + sy, z))) {
				world.setBlock(BlockPos.containing(x, y + sy, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.TREBLE_BLOOM.get().defaultBlockState(), "blockstate", 4)), 3);
				sy = sy + 1;
			}
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y + sy, z))) {
			world.setBlock(BlockPos.containing(x, y + sy, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.TREBLE_BLOOM.get().defaultBlockState(), "blockstate", 3)), 3);
		}
		return true;
	}
}
