package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class InvertedRootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double x_pol = 0;
		double z_pol = 0;
		double sx = 0;
		double sz = 0;
		double sy = 0;
		boolean found = false;
		x_pol = 0;
		z_pol = 0;
		if (Math.random() < 0.5) {
			if (Math.random() < 0.5) {
				x_pol = 1;
			} else {
				x_pol = -1;
			}
		} else {
			if (Math.random() < 0.5) {
				z_pol = 1;
			} else {
				z_pol = -1;
			}
		}
		sx = 0;
		sy = 0;
		sz = 0;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 3, 8); index0++) {
			if (x_pol != 0) {
				if (!world.getBlockState(BlockPos.containing(x + sx, y, z)).canOcclude()) {
					world.setBlock(BlockPos.containing(x + sx, y, z), (new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.AZURE_SEPAL_LOG.get().defaultBlockState(), "axis", "x")), 3);
				}
			} else if (z_pol != 0) {
				if (!world.getBlockState(BlockPos.containing(x, y, z + sz)).canOcclude()) {
					world.setBlock(BlockPos.containing(x, y, z + sz), (new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.AZURE_SEPAL_LOG.get().defaultBlockState(), "axis", "z")), 3);
				}
			}
			if (x_pol != 0) {
				sx = sx + x_pol;
			} else if (z_pol != 0) {
				sz = sz + z_pol;
			}
		}
		if (x_pol != 0) {
			if (!world.getBlockState(BlockPos.containing(x + sx, y, z)).canOcclude()) {
				world.setBlock(BlockPos.containing(x + sx, y, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.AZURE_SEPAL_WOOD.get().defaultBlockState(), "axis", "x")), 3);
			}
		} else if (z_pol != 0) {
			if (!world.getBlockState(BlockPos.containing(x, y, z + sz)).canOcclude()) {
				world.setBlock(BlockPos.containing(x, y, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.AZURE_SEPAL_WOOD.get().defaultBlockState(), "axis", "z")), 3);
			}
		}
		while (sy < 20 && !found) {
			if (!world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).canOcclude()) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), EndlessEndModBlocks.AZURE_SEPAL_LOG.get().defaultBlockState(), 3);
			}
			if (world.getBlockState(BlockPos.containing(x + sx, y + sy + 1, z + sz)).canOcclude()) {
				if (Blocks.END_STONE == (world.getBlockState(BlockPos.containing(x + sx, y + sy + 1, z + sz))).getBlock() || EndlessEndModBlocks.STRONG_STONE.get() == (world.getBlockState(BlockPos.containing(x + sx, y + sy + 1, z + sz))).getBlock()
						|| EndlessEndModBlocks.GOLDEN_HUMUS.get() == (world.getBlockState(BlockPos.containing(x + sx, y + sy + 1, z + sz))).getBlock()
						|| EndlessEndModBlocks.COBBLED_ENDSTONE.get() == (world.getBlockState(BlockPos.containing(x + sx, y + sy + 1, z + sz))).getBlock()) {
					world.setBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
				}
				found = true;
			}
			if (Math.random() < 0.3) {
				if (!world.getBlockState(BlockPos.containing(x + sx + 1, y + sy, z + sz)).canOcclude()) {
					world.setBlock(BlockPos.containing(x + sx + 1, y + sy, z + sz), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
				}
				if (!world.getBlockState(BlockPos.containing((x + sx) - 1, y + sy, z + sz)).canOcclude()) {
					world.setBlock(BlockPos.containing((x + sx) - 1, y + sy, z + sz), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
				}
				if (!world.getBlockState(BlockPos.containing(x + sx, y + sy, (z + sz) - 1)).canOcclude()) {
					world.setBlock(BlockPos.containing(x + sx, y + sy, (z + sz) - 1), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
				}
				if (!world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz + 1)).canOcclude()) {
					world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz + 1), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
				}
			}
			sy = sy + 1;
		}
	}
}
