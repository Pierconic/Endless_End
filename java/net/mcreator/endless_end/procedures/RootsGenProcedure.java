package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class RootsGenProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		double ox = 0;
		double oz = 0;
		if (VoidGenHeightProcedure.execute(world, x, z) < 64) {
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 3, 8); index0++) {
				ox = Mth.nextInt(RandomSource.create(), -7, 7);
				oz = Mth.nextInt(RandomSource.create(), -7, 7);
				if (VoidGenHeightProcedure.execute(world, x + ox, z + oz) < 64) {
					if (Math.random() < 0.7) {
						world.setBlock(BlockPos.containing(x + ox, VoidGenHeightProcedure.execute(world, x + ox, z + oz) - 1, z + oz), (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(EndlessEndModBlocks.GOLDEN_SPROUTS.get().defaultBlockState(), Direction.DOWN)), 3);
					} else {
						world.setBlock(BlockPos.containing(x + ox, VoidGenHeightProcedure.execute(world, x + ox, z + oz) - 1, z + oz), (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(EndlessEndModBlocks.GOLDEN_ROOTS.get().defaultBlockState(), Direction.DOWN)), 3);
					}
				}
			}
			return true;
		}
		return false;
	}
}
