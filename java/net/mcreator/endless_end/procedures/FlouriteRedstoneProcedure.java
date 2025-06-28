package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class FlouriteRedstoneProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double power = 0;
		power = Math.max(world instanceof Level _lvl_getRedPow ? _lvl_getRedPow.getSignal(BlockPos.containing(x, y, z), Direction.UP) : 0,
				Math.max(world instanceof Level _lvl_getRedPow ? _lvl_getRedPow.getSignal(BlockPos.containing(x, y, z), Direction.DOWN) : 0,
						Math.max(world instanceof Level _lvl_getRedPow ? _lvl_getRedPow.getSignal(BlockPos.containing(x, y, z), Direction.NORTH) : 0,
								Math.max(world instanceof Level _lvl_getRedPow ? _lvl_getRedPow.getSignal(BlockPos.containing(x, y, z), Direction.SOUTH) : 0,
										Math.max(world instanceof Level _lvl_getRedPow ? _lvl_getRedPow.getSignal(BlockPos.containing(x, y, z), Direction.WEST) : 0,
												world instanceof Level _lvl_getRedPow ? _lvl_getRedPow.getSignal(BlockPos.containing(x, y, z), Direction.EAST) : 0)))));
		if (power != 0) {
			world.setBlock(BlockPos.containing(x, y, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", (int) power)), 3);
		}
	}
}
