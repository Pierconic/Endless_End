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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SideWinderPlacementProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean success = false;
		double offset = 0;
		double mini_off = 0;
		double off_1 = 0;
		double off_2 = 0;
		double new_oz = 0;
		double new_ox = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.END_STONE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.STRONG_STONE.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.ROOTED_ENDSTONE.get()) {
			if (world.isEmptyBlock(BlockPos.containing(x + 12, y, z))) {
				offset = 1;
				for (int index0 = 0; index0 < 13; index0++) {
					if (world.isEmptyBlock(BlockPos.containing(x + offset, y, z)) && world.isEmptyBlock(BlockPos.containing(x + offset, y - 1, z)) && world.isEmptyBlock(BlockPos.containing(x + offset, y, z - 1))
							&& world.isEmptyBlock(BlockPos.containing(x + offset, y, z + 1))
							&& ((world.getBlockState(BlockPos.containing((x + offset) - 1, y, z))).getBlock() == Blocks.END_STONE
									|| (world.getBlockState(BlockPos.containing((x + offset) - 1, y, z))).getBlock() == EndlessEndModBlocks.STRONG_STONE.get()
									|| (world.getBlockState(BlockPos.containing((x + offset) - 1, y, z))).getBlock() == EndlessEndModBlocks.ROOTED_ENDSTONE.get())
							&& !success) {
						success = true;
						mini_off = 0;
						for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 2, 8); index1++) {
							world.setBlock(BlockPos.containing(x + offset + mini_off, y, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "x")), 3);
							SepallFallProcedure.execute(world, x + offset + mini_off, y - 1, z, 7);
							mini_off = mini_off + 1;
						}
						world.setBlock(BlockPos.containing(x + offset + mini_off, y, z), (new Object() {
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
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 11)), "face", "wall")), Direction.EAST)), 3);
						mini_off = 1;
						for (int index2 = 0; index2 < Mth.nextInt(RandomSource.create(), 6, 12); index2++) {
							new_ox = x;
							new_oz = z + Mth.nextInt(RandomSource.create(), -10, 10);
							if (world instanceof ServerLevel _level26 && _level26.isLoaded(BlockPos.containing(new_ox, y, new_oz))) {
								SideWinderNonRecProcedure.execute(world, new_ox, y + Mth.nextInt(RandomSource.create(), -8, 8), new_oz);
							}
						}
						for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 4, 8); index3++) {
							for (int index4 = 0; index4 < Mth.nextInt(RandomSource.create(), 2, 4); index4++) {
								off_1 = Mth.nextInt(RandomSource.create(), -1, 1);
								off_2 = Mth.nextInt(RandomSource.create(), -1, 1);
								if ((world.getBlockState(BlockPos.containing((x + offset) - mini_off, y + off_1, z + off_2))).getBlock() == Blocks.END_STONE
										|| (world.getBlockState(BlockPos.containing((x + offset) - mini_off, y + off_1, z + off_2))).getBlock() == EndlessEndModBlocks.COBBLED_ENDSTONE.get()
										|| (world.getBlockState(BlockPos.containing((x + offset) - mini_off, y + off_1, z + off_2))).getBlock() == EndlessEndModBlocks.STRONG_STONE.get()) {
									world.setBlock(BlockPos.containing((x + offset) - mini_off, y + off_1, z + off_2), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
								}
							}
							mini_off = mini_off + 1;
						}
					}
					offset = offset + 1;
				}
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 12, y, z))) {
				offset = 1;
				for (int index5 = 0; index5 < 13; index5++) {
					if (world.isEmptyBlock(BlockPos.containing(x - offset, y, z)) && world.isEmptyBlock(BlockPos.containing(x - offset, y - 1, z)) && world.isEmptyBlock(BlockPos.containing(x - offset, y, z - 1))
							&& world.isEmptyBlock(BlockPos.containing(x - offset, y, z + 1))
							&& ((world.getBlockState(BlockPos.containing(x - offset + 1, y, z))).getBlock() == Blocks.END_STONE || (world.getBlockState(BlockPos.containing(x - offset + 1, y, z))).getBlock() == EndlessEndModBlocks.STRONG_STONE.get()
									|| (world.getBlockState(BlockPos.containing(x - offset + 1, y, z))).getBlock() == EndlessEndModBlocks.ROOTED_ENDSTONE.get())
							&& !success) {
						success = true;
						mini_off = 0;
						for (int index6 = 0; index6 < Mth.nextInt(RandomSource.create(), 1, 7); index6++) {
							world.setBlock(BlockPos.containing((x - offset) - mini_off, y, z), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "x")), 3);
							SepallFallProcedure.execute(world, (x - offset) - mini_off, y - 1, z, 7);
							mini_off = mini_off + 1;
						}
						world.setBlock(BlockPos.containing((x - offset) - mini_off, y, z), (new Object() {
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
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 11)), "face", "wall")), Direction.WEST)), 3);
						mini_off = 1;
						for (int index7 = 0; index7 < Mth.nextInt(RandomSource.create(), 6, 12); index7++) {
							new_ox = x + Mth.nextInt(RandomSource.create(), -10, 10);
							new_oz = z;
							if (world instanceof ServerLevel _level59 && _level59.isLoaded(BlockPos.containing(new_ox, y, new_oz))) {
								SideWinderNonRecProcedure.execute(world, new_ox, y + Mth.nextInt(RandomSource.create(), -8, 8), new_oz);
							}
						}
						for (int index8 = 0; index8 < Mth.nextInt(RandomSource.create(), 4, 8); index8++) {
							for (int index9 = 0; index9 < Mth.nextInt(RandomSource.create(), 2, 4); index9++) {
								off_1 = Mth.nextInt(RandomSource.create(), -1, 1);
								off_2 = Mth.nextInt(RandomSource.create(), -1, 1);
								if ((world.getBlockState(BlockPos.containing(x - offset + mini_off, y + off_1, z + off_2))).getBlock() == Blocks.END_STONE
										|| (world.getBlockState(BlockPos.containing(x - offset + mini_off, y + off_1, z + off_2))).getBlock() == EndlessEndModBlocks.COBBLED_ENDSTONE.get()
										|| (world.getBlockState(BlockPos.containing(x - offset + mini_off, y + off_1, z + off_2))).getBlock() == EndlessEndModBlocks.STRONG_STONE.get()) {
									world.setBlock(BlockPos.containing(x - offset + mini_off, y + off_1, z + off_2), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
								}
							}
							mini_off = mini_off + 1;
						}
					}
					offset = offset + 1;
				}
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y, z - 12))) {
				offset = 1;
				for (int index10 = 0; index10 < 13; index10++) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - offset)) && world.isEmptyBlock(BlockPos.containing(x, y - 1, z - offset)) && world.isEmptyBlock(BlockPos.containing(x - 1, y, z - offset))
							&& world.isEmptyBlock(BlockPos.containing(x + 1, y, z - offset))
							&& ((world.getBlockState(BlockPos.containing(x, y, z - offset + 1))).getBlock() == Blocks.END_STONE || (world.getBlockState(BlockPos.containing(x, y, z - offset + 1))).getBlock() == EndlessEndModBlocks.STRONG_STONE.get()
									|| (world.getBlockState(BlockPos.containing(x, y, z - offset + 1))).getBlock() == EndlessEndModBlocks.ROOTED_ENDSTONE.get())
							&& !success) {
						success = true;
						mini_off = 0;
						for (int index11 = 0; index11 < Mth.nextInt(RandomSource.create(), 1, 7); index11++) {
							world.setBlock(BlockPos.containing(x, y, (z - offset) - mini_off), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "z")), 3);
							SepallFallProcedure.execute(world, x, y - 1, (z - offset) - mini_off, 7);
							mini_off = mini_off + 1;
						}
						world.setBlock(BlockPos.containing(x, y, (z - offset) - mini_off), (new Object() {
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
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 11)), "face", "wall")), Direction.NORTH)), 3);
						mini_off = 1;
						for (int index12 = 0; index12 < Mth.nextInt(RandomSource.create(), 6, 12); index12++) {
							new_ox = x;
							new_oz = z + Mth.nextInt(RandomSource.create(), -10, 10);
							if (world instanceof ServerLevel _level92 && _level92.isLoaded(BlockPos.containing(new_ox, y, new_oz))) {
								SideWinderNonRecProcedure.execute(world, new_ox, y + Mth.nextInt(RandomSource.create(), -8, 8), new_oz);
							}
						}
						for (int index13 = 0; index13 < Mth.nextInt(RandomSource.create(), 4, 8); index13++) {
							for (int index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 2, 4); index14++) {
								off_1 = Mth.nextInt(RandomSource.create(), -1, 1);
								off_2 = Mth.nextInt(RandomSource.create(), -1, 1);
								if ((world.getBlockState(BlockPos.containing(x + off_2, y + off_1, z - offset + mini_off))).getBlock() == Blocks.END_STONE
										|| (world.getBlockState(BlockPos.containing(x + off_2, y + off_1, z - offset + mini_off))).getBlock() == EndlessEndModBlocks.COBBLED_ENDSTONE.get()
										|| (world.getBlockState(BlockPos.containing(x + off_2, y + off_1, z - offset + mini_off))).getBlock() == EndlessEndModBlocks.STRONG_STONE.get()) {
									world.setBlock(BlockPos.containing(x + off_2, y + off_1, z - offset + mini_off), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
								}
							}
							mini_off = mini_off + 1;
						}
					}
					offset = offset + 1;
				}
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y, z + 12))) {
				offset = 1;
				for (int index15 = 0; index15 < 13; index15++) {
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + offset)) && world.isEmptyBlock(BlockPos.containing(x, y - 1, z + offset)) && world.isEmptyBlock(BlockPos.containing(x - 1, y, z + offset))
							&& world.isEmptyBlock(BlockPos.containing(x + 1, y, z + offset))
							&& ((world.getBlockState(BlockPos.containing(x, y, (z + offset) - 1))).getBlock() == Blocks.END_STONE
									|| (world.getBlockState(BlockPos.containing(x, y, (z + offset) - 1))).getBlock() == EndlessEndModBlocks.STRONG_STONE.get()
									|| (world.getBlockState(BlockPos.containing(x, y, (z + offset) - 1))).getBlock() == EndlessEndModBlocks.ROOTED_ENDSTONE.get())
							&& !success) {
						success = true;
						mini_off = 0;
						for (int index16 = 0; index16 < Mth.nextInt(RandomSource.create(), 1, 7); index16++) {
							world.setBlock(BlockPos.containing(x, y, z + offset + mini_off), (new Object() {
								public BlockState with(BlockState _bs, String _property, String _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
								}
							}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "z")), 3);
							SepallFallProcedure.execute(world, x, y - 1, z + offset + mini_off, 7);
							mini_off = mini_off + 1;
						}
						world.setBlock(BlockPos.containing(x, y, z + offset + mini_off), (new Object() {
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
						}.with(EndlessEndModBlocks.TUNEROD_STEM.get().defaultBlockState(), "blockstate", 11)), "face", "wall")), Direction.SOUTH)), 3);
						mini_off = 1;
						for (int index17 = 0; index17 < Mth.nextInt(RandomSource.create(), 6, 12); index17++) {
							new_ox = x + Mth.nextInt(RandomSource.create(), -10, 10);
							new_oz = z;
							if (world instanceof ServerLevel _level125 && _level125.isLoaded(BlockPos.containing(new_ox, y, new_oz))) {
								SideWinderNonRecProcedure.execute(world, new_ox, y + Mth.nextInt(RandomSource.create(), -8, 8), new_oz);
							}
						}
						for (int index18 = 0; index18 < Mth.nextInt(RandomSource.create(), 4, 8); index18++) {
							for (int index19 = 0; index19 < Mth.nextInt(RandomSource.create(), 2, 4); index19++) {
								off_1 = Mth.nextInt(RandomSource.create(), -1, 1);
								off_2 = Mth.nextInt(RandomSource.create(), -1, 1);
								if ((world.getBlockState(BlockPos.containing(x + off_2, y + off_1, (z + offset) - mini_off))).getBlock() == Blocks.END_STONE
										|| (world.getBlockState(BlockPos.containing(x + off_2, y + off_1, (z + offset) - mini_off))).getBlock() == EndlessEndModBlocks.COBBLED_ENDSTONE.get()
										|| (world.getBlockState(BlockPos.containing(x + off_2, y + off_1, (z + offset) - mini_off))).getBlock() == EndlessEndModBlocks.STRONG_STONE.get()) {
									world.setBlock(BlockPos.containing(x + off_2, y + off_1, (z + offset) - mini_off), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
								}
							}
							mini_off = mini_off + 1;
						}
					}
					offset = offset + 1;
				}
			}
		}
	}
}
