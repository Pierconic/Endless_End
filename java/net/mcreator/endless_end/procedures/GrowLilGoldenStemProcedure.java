package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class GrowLilGoldenStemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sy1 = 0;
		double sx = 0;
		double sz = 0;
		double dr = 0;
		boolean grounded = false;
		sy1 = 1;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 4); index0++) {
			world.setBlock(BlockPos.containing(x, y - sy1, z), EndlessEndModBlocks.AZURE_SEPAL_LOG.get().defaultBlockState(), 3);
			if (Math.random() < 0.25) {
				world.setBlock(BlockPos.containing(x + 1, y - sy1, z), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y - sy1, z), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y - sy1, z + 1), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y - sy1, z - 1), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
			}
			sy1 = sy1 + 1;
		}
		world.setBlock(BlockPos.containing(x, y - sy1, z), EndlessEndModBlocks.AZURE_SEPAL_WOOD.get().defaultBlockState(), 3);
		if (Math.random() < 0.5) {
			dr = 1;
		} else {
			dr = -1;
		}
		sz = 0;
		sx = 0;
		if (Math.random() < 0.5) {
			sz = 1;
			for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 3, 6); index1++) {
				world.setBlock(BlockPos.containing(x, y - sy1, z + sz * dr), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.AZURE_SEPAL_LOG.get().defaultBlockState(), "axis", "z")), 3);
				if (Math.random() < 0.4) {
					SwirlingVineProcedure.execute(world, x, y - sy1, z + sz * dr);
				}
				sz = sz + 1;
			}
			world.setBlock(BlockPos.containing(x, y - sy1, z + sz * dr), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with(EndlessEndModBlocks.AZURE_SEPAL_WOOD.get().defaultBlockState(), "axis", "z")), 3);
		} else {
			sx = 1;
			for (int index2 = 0; index2 < Mth.nextInt(RandomSource.create(), 3, 6); index2++) {
				world.setBlock(BlockPos.containing(x + sx * dr, y - sy1, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.AZURE_SEPAL_LOG.get().defaultBlockState(), "axis", "x")), 3);
				if (Math.random() < 0.4) {
					SwirlingVineProcedure.execute(world, x + sx * dr, y - sy1, z);
				}
				sx = sx + 1;
			}
			world.setBlock(BlockPos.containing(x + sx * dr, y - sy1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with(EndlessEndModBlocks.AZURE_SEPAL_WOOD.get().defaultBlockState(), "axis", "x")), 3);
		}
		if (!world.canSeeSkyFromBelowWater(BlockPos.containing(x + sx * dr, y - sy1, z + sz * dr))) {
			sy1 = sy1 - 1;
			for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 8, 16); index3++) {
				if (world.getBlockState(BlockPos.containing(x + sx * dr, y - sy1, z + sz * dr)).canOcclude()) {
					grounded = true;
					if (!((world.getBlockState(BlockPos.containing(x + sx * dr, y - sy1, z + sz * dr))).getBlock() == EndlessEndModBlocks.AZURE_SEPAL_LOG.get()
							|| (world.getBlockState(BlockPos.containing(x + sx * dr, y - sy1, z + sz * dr))).getBlock() == EndlessEndModBlocks.AZURE_SEPAL_WOOD.get())) {
						world.setBlock(BlockPos.containing(x + sx * dr, y - sy1, z + sz * dr), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
					}
				} else {
					world.setBlock(BlockPos.containing(x + sx * dr, y - sy1, z + sz * dr), EndlessEndModBlocks.AZURE_SEPAL_LOG.get().defaultBlockState(), 3);
					if (Math.random() < 0.25) {
						world.setBlock(BlockPos.containing(x + sx * dr + 1, y - sy1, z + sz * dr), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing((x + sx * dr) - 1, y - sy1, z + sz * dr), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x + sx * dr, y - sy1, z + sz * dr + 1), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(x + sx * dr, y - sy1, (z + sz * dr) - 1), EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState(), 3);
					}
					sy1 = sy1 - 1;
				}
			}
			if (!grounded) {
				world.setBlock(BlockPos.containing(x + sx * dr, y - sy1, z + sz * dr), EndlessEndModBlocks.AZURE_SEPAL_WOOD.get().defaultBlockState(), 3);
			}
		}
	}
}
