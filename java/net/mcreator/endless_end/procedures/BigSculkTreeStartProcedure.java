package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class BigSculkTreeStartProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double height = 0;
		double sx = 0;
		double sz = 0;
		double sy = 0;
		if (y < 78) {
			height = Mth.nextInt(RandomSource.create(), 20, 40);
			sx = 0;
			sz = 0;
			for (int index0 = 0; index0 < 4; index0++) {
				sy = 0;
				for (int index1 = 0; index1 < (int) height; index1++) {
					if (sy == height || sy == height - 1) {
						world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), EndlessEndModBlocks.STRIPPED_JOINT.get().defaultBlockState(), 3);
						if (Math.random() < 0.5) {
							BigSculkTreeBranchProcedure.execute(world, x + sx, y + sy, z + sz, Direction.UP, 0);
						}
					} else if (sy / height > 0.8 || sy / height > 0.6 && Math.random() < 0.5) {
						world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), EndlessEndModBlocks.STRIPPED_VERTABRAE.get().defaultBlockState(), 3);
						if (Math.random() < 0.5) {
							BigSculkTreeBranchProcedure.execute(world, x + sx, y + sy, z + sz, new Object() {
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
							}.getValue(), 3);
						} else {
							if (Math.random() < 0.3) {
								VeinifyProcedure.execute(world, x + sx, y + sy, z + sz);
							}
						}
					} else {
						world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), EndlessEndModBlocks.VERTABRAE.get().defaultBlockState(), 3);
						if (Math.random() < 0.1) {
							if (world.isEmptyBlock(BlockPos.containing(x + sx + 1, y + sy, z + sz)) && Math.random() < 0.5) {
								world.setBlock(BlockPos.containing(x + sx + 1, y + sy, z + sz), (new Object() {
									public BlockState with(BlockState _bs, String _property, String _newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
										return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
									}
								}.with(EndlessEndModBlocks.VERTABRAE.get().defaultBlockState(), "axis", "x")), 3);
							}
							if (world.isEmptyBlock(BlockPos.containing(x + sx + -1, y + sy, z + sz)) && Math.random() < 0.5) {
								world.setBlock(BlockPos.containing(x + sx + -1, y + sy, z + sz), (new Object() {
									public BlockState with(BlockState _bs, String _property, String _newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
										return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
									}
								}.with(EndlessEndModBlocks.VERTABRAE.get().defaultBlockState(), "axis", "x")), 3);
							}
							if (world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz + -1)) && Math.random() < 0.5) {
								world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz + -1), (new Object() {
									public BlockState with(BlockState _bs, String _property, String _newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
										return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
									}
								}.with(EndlessEndModBlocks.VERTABRAE.get().defaultBlockState(), "axis", "z")), 3);
							}
							if (world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz + 1)) && Math.random() < 0.5) {
								world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz + 1), (new Object() {
									public BlockState with(BlockState _bs, String _property, String _newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
										return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
									}
								}.with(EndlessEndModBlocks.VERTABRAE.get().defaultBlockState(), "axis", "z")), 3);
							}
						} else {
							if (Math.random() < 0.5) {
								SprawlThornsProcedure.execute(world, x + sx, y + sy, z + sz, "y");
							}
						}
					}
					sy = sy + 1;
				}
				if (sx == 1) {
					sz = 1;
					sx = 0;
				} else if (sz == 1) {
					sx = 1;
				} else {
					sx = 1;
				}
			}
			NaturalBoneSprawlProcedure.execute(world, x + sx, y + sy, z + sz);
			return true;
		}
		return false;
	}
}
