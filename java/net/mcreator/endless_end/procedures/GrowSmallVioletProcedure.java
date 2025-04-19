package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class GrowSmallVioletProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double Lambda, double maxHeight, double maxWidth) {
		boolean trunk_1_x_axis = false;
		double trunk_1 = 0;
		double trunk_2 = 0;
		double trunk_3 = 0;
		trunk_1 = 1;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 4, (int) maxHeight); index0++) {
			world.setBlock(BlockPos.containing(x, y + trunk_1, z), EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
			if (Math.random() < 0.4 && trunk_1 > 2) {
				if (Math.random() < 0.5) {
					if (Math.random() < 0.5 && !((world.getBlockState(BlockPos.containing(x + 1, (y + trunk_1) - 1, z))).getBlock() == EndlessEndModBlocks.VIOLET_SEPAL_LOG.get())) {
						world.setBlock(BlockPos.containing(x + 1, y + trunk_1, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "x")), 3);
						SepallFallProcedure.execute(world, x + 1, (y + trunk_1) - 1, z, 9);
						if (Math.random() < 0.25) {
							SepallFallProcedure.execute(world, x + 2, (y + trunk_1) - 1, z, 6);
							world.setBlock(BlockPos.containing(x + 2, y + trunk_1, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "x")), 3);
						}
					} else if (Math.random() < 0.5 && !((world.getBlockState(BlockPos.containing(x - 1, (y + trunk_1) - 1, z))).getBlock() == EndlessEndModBlocks.VIOLET_SEPAL_LOG.get())) {
						SepallFallProcedure.execute(world, x - 1, (y + trunk_1) - 1, z, 9);
						world.setBlock(BlockPos.containing(x - 1, y + trunk_1, z), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "x")), 3);
						if (Math.random() < 0.25) {
							SepallFallProcedure.execute(world, x - 2, (y + trunk_1) - 1, z, 6);
							world.setBlock(BlockPos.containing(x - 2, y + trunk_1, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "x")), 3);
						}
					}
				} else {
					if (Math.random() < 0.5 && !((world.getBlockState(BlockPos.containing(x, (y + trunk_1) - 1, z + 1))).getBlock() == EndlessEndModBlocks.VIOLET_SEPAL_LOG.get())) {
						SepallFallProcedure.execute(world, x, (y + trunk_1) - 1, z + 1, 9);
						world.setBlock(BlockPos.containing(x, y + trunk_1, z + 1), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "z")), 3);
						if (Math.random() < 0.25) {
							SepallFallProcedure.execute(world, x, (y + trunk_1) - 1, z + 2, 6);
							world.setBlock(BlockPos.containing(x, y + trunk_1, z + 2), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "z")), 3);
						}
					} else if (Math.random() < 0.5 && !((world.getBlockState(BlockPos.containing(x, (y + trunk_1) - 1, z - 1))).getBlock() == EndlessEndModBlocks.VIOLET_SEPAL_LOG.get())) {
						SepallFallProcedure.execute(world, x, (y + trunk_1) - 1, z - 1, 9);
						world.setBlock(BlockPos.containing(x, y + trunk_1, z - 1), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "z")), 3);
						if (Math.random() < 0.25) {
							SepallFallProcedure.execute(world, x, (y + trunk_1) - 1, z - 2, 6);
							world.setBlock(BlockPos.containing(x, y + trunk_1, z - 2), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "z")), 3);
						}
					}
				}
			}
			trunk_1 = trunk_1 + 1;
		}
		world.setBlock(BlockPos.containing(x, y + trunk_1, z), EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
		trunk_1 = trunk_1 + 1;
		world.setBlock(BlockPos.containing(x, y + trunk_1, z), EndlessEndModBlocks.VIOLET_SEPAL_WOOD.get().defaultBlockState(), 3);
		trunk_1_x_axis = true;
		if (Math.random() < 0.5) {
			trunk_1_x_axis = false;
			SepallFallProcedure.execute(world, x + 1, y + trunk_1, z, 9);
			SepallFallProcedure.execute(world, x - 1, y + trunk_1, z, 9);
		} else {
			SepallFallProcedure.execute(world, x, y + trunk_1, z - 1, 9);
			SepallFallProcedure.execute(world, x, y + trunk_1, z + 1, 9);
		}
		SepallFallProcedure.execute(world, x - 1, (y + trunk_1) - Mth.nextInt(RandomSource.create(), 1, 2), z - 1, 4);
		SepallFallProcedure.execute(world, x + 1, (y + trunk_1) - Mth.nextInt(RandomSource.create(), 1, 2), z - 1, 4);
		SepallFallProcedure.execute(world, x - 1, (y + trunk_1) - Mth.nextInt(RandomSource.create(), 1, 2), z + 1, 4);
		SepallFallProcedure.execute(world, x + 1, (y + trunk_1) - Mth.nextInt(RandomSource.create(), 1, 2), z + 1, 4);
		trunk_2 = 1;
		for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, (int) maxWidth); index1++) {
			if (trunk_1_x_axis) {
				world.setBlock(BlockPos.containing(x + trunk_2, y + trunk_1, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "x")), 3);
				world.setBlock(BlockPos.containing(x - trunk_2, y + trunk_1, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "x")), 3);
				SepallFallProcedure.execute(world, x + trunk_2, (y + trunk_1) - 1, z, 11);
				SepallFallProcedure.execute(world, x - trunk_2, (y + trunk_1) - 1, z, 11);
			} else {
				world.setBlock(BlockPos.containing(x, y + trunk_1, z + trunk_2), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "z")), 3);
				world.setBlock(BlockPos.containing(x, y + trunk_1, z - trunk_2), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "z")), 3);
				SepallFallProcedure.execute(world, x, (y + trunk_1) - 1, z + trunk_2, 11);
				SepallFallProcedure.execute(world, x, (y + trunk_1) - 1, z - trunk_2, 11);
			}
			trunk_2 = trunk_2 + 1;
		}
		if (trunk_1_x_axis) {
			world.setBlock(BlockPos.containing(x - trunk_2, y + trunk_1, z), EndlessEndModBlocks.VIOLET_SEPAL_WOOD.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + trunk_2, y + trunk_1, z), EndlessEndModBlocks.VIOLET_SEPAL_WOOD.get().defaultBlockState(), 3);
		} else {
			world.setBlock(BlockPos.containing(x, y + trunk_1, z - trunk_2), EndlessEndModBlocks.VIOLET_SEPAL_WOOD.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y + trunk_1, z + trunk_2), EndlessEndModBlocks.VIOLET_SEPAL_WOOD.get().defaultBlockState(), 3);
		}
		if (Math.random() < 0.25 || Lambda <= 0) {
			for (int index2 = 0; index2 < Mth.nextInt(RandomSource.create(), 1, 3); index2++) {
				trunk_1 = trunk_1 + 1;
				if (trunk_1_x_axis) {
					world.setBlock(BlockPos.containing(x + trunk_2, y + trunk_1, z), EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
					SimpleTuneshootProcedure.execute(world,x + trunk_2, y + trunk_1 + 1, z,true);
					world.setBlock(BlockPos.containing(x - trunk_2, y + trunk_1, z), EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
					SimpleTuneshootProcedure.execute(world,x - trunk_2, y + trunk_1 + 1, z,true);
				} else {
					world.setBlock(BlockPos.containing(x, y + trunk_1, z + trunk_2), EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
					SimpleTuneshootProcedure.execute(world,x, y + trunk_1 + 1, z+ trunk_2,true);
					world.setBlock(BlockPos.containing(x, y + trunk_1, z - trunk_2), EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
					SimpleTuneshootProcedure.execute(world,x, y + trunk_1 + 1, z -trunk_2,true);
				}
			}
		} else {
			if (trunk_1_x_axis) {
				if (Math.random() < 0.7) {
					GrowSmallVioletProcedure.execute(world, x - trunk_2, y + trunk_1, z, Lambda - 1, 9, 2);
				} else {
					world.setBlock(BlockPos.containing(x - trunk_2, y + trunk_1 + 1, z), EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
				}
				if (Math.random() < 0.7) {
					GrowSmallVioletProcedure.execute(world, x + trunk_2, y + trunk_1, z, Lambda - 1, 9, 2);
				} else {
					world.setBlock(BlockPos.containing(x + trunk_2, y + trunk_1 + 1, z), EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
				}
			} else {
				if (Math.random() < 0.7) {
					GrowSmallVioletProcedure.execute(world, x, y + trunk_1, z - trunk_2, Lambda - 1, 9, 2);
				} else {
					world.setBlock(BlockPos.containing(x, y + trunk_1 + 1, z - trunk_2), EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
				}
				if (Math.random() < 0.7) {
					GrowSmallVioletProcedure.execute(world, x, y + trunk_1, z + trunk_2, Lambda - 1, 9, 2);
				} else {
					world.setBlock(BlockPos.containing(x, y + trunk_1 + 1, z + trunk_2), EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
				}
			}
		}
	}
}