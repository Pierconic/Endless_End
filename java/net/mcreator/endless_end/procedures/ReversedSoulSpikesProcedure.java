package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class ReversedSoulSpikesProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		double ox = 0;
		double oz = 0;
		double sy = 0;
		double start_y = 0;
		double height = 0;
		double topper = 0;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 24, 48); index0++) {
			ox = Mth.nextInt(RandomSource.create(), -9, 9);
			oz = Mth.nextInt(RandomSource.create(), -9, 9);
			sy = 0;
			start_y = VoidHeightProcedure.execute(world, x + ox, z + oz) - 0;
			if ((world.getBlockState(BlockPos.containing(x + ox, start_y, z + oz))).getBlock() == EndlessEndModBlocks.STRONG_STONE.get() || (world.getBlockState(BlockPos.containing(x + ox, start_y, z + oz))).getBlock() == Blocks.END_STONE
					|| (world.getBlockState(BlockPos.containing(x + ox, start_y, z + oz))).getBlock() == EndlessEndModBlocks.COBBLED_ENDSTONE.get()) {
				if (Math.random() < 0.7) {
					height = Mth.nextInt(RandomSource.create(), 2, 10);
					for (int index1 = 0; index1 < (int) height; index1++) {
						if (sy == Math.round(height * 0.6)) {
							world.setBlock(BlockPos.containing(x + ox, start_y - sy, z + oz), (new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with(EndlessEndModBlocks.CALCIFIED_ENDSTONE.get().defaultBlockState(), "blockstate", 1)), 3);
						} else if (sy < height * 0.6) {
							world.setBlock(BlockPos.containing(x + ox, start_y - sy, z + oz), Blocks.END_STONE.defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x + ox, start_y - sy, z + oz), Blocks.CALCITE.defaultBlockState(), 3);
						}
						sy = sy + 1;
					}
				} else {
					height = Mth.nextInt(RandomSource.create(), 7, 13);
					topper = Mth.nextInt(RandomSource.create(), 2, 6);
					for (int index2 = 0; index2 < (int) height; index2++) {
						if (sy == Math.round(height * 0.6)) {
							world.setBlock(BlockPos.containing(x + ox, start_y - sy, z + oz), (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.CALCIFIED_ENDSTONE.get().defaultBlockState(), Direction.DOWN)), 3);
						} else if (sy < height * 0.6) {
							if (Math.random() < 0.05) {
								world.setBlock(BlockPos.containing(x + ox, start_y - sy, z + oz), EndlessEndModBlocks.END_AMETHYST.get().defaultBlockState(), 3);
							} else if (Math.random() < 0.005) {
								world.setBlock(BlockPos.containing(x + ox, start_y - sy, z + oz), EndlessEndModBlocks.END_DIAMONDS.get().defaultBlockState(), 3);
							} else {
								world.setBlock(BlockPos.containing(x + ox, start_y - sy, z + oz), Blocks.END_STONE.defaultBlockState(), 3);
							}
						} else {
							world.setBlock(BlockPos.containing(x + ox, start_y - sy, z + oz), Blocks.CALCITE.defaultBlockState(), 3);
						}
						sy = sy + 1;
					}
					for (int index3 = 0; index3 < (int) topper; index3++) {
						world.setBlock(BlockPos.containing(x + ox, start_y - sy, z + oz), EndlessEndModBlocks.FLOURITE.get().defaultBlockState(), 3);
						sy = sy + 1;
					}
				}
			}
		}
		return true;
	}
}
