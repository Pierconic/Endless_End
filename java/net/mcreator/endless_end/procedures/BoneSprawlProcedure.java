package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class BoneSprawlProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direct, boolean locked, double lambda, double mini_sprawl) {
		if (direct == null)
			return;
		double ox = 0;
		double oy = 0;
		double oz = 0;
		String axis = "";
		Direction new_direct = Direction.NORTH;
		boolean downward = false;
		ox = 0;
		oy = 0;
		oz = 0;
		if (direct == Direction.UP) {
			oy = 1;
			axis = "y";
		} else if (direct == Direction.DOWN) {
			oy = -1;
			axis = "y";
		} else if (direct == Direction.WEST) {
			ox = -1;
			axis = "x";
		} else if (direct == Direction.EAST) {
			ox = 1;
			axis = "x";
		} else if (direct == Direction.NORTH) {
			oz = -1;
			axis = "z";
		} else {
			oz = 1;
			axis = "z";
		}
		if (locked) {
			if (!world.getBlockState(BlockPos.containing(x + ox, y + oy, z + oz)).canOcclude() && lambda > 0) {
				world.setBlock(BlockPos.containing(x + ox, y + oy, z + oz), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.VERTABRAE.get().defaultBlockState(), "axis", axis)), 3);
				BoneSprawlProcedure.execute(world, x + ox, y + oy, z + oz, direct, true, lambda - 1, mini_sprawl + 1);
				if (Math.random() < 0.3) {
					SprawlThornsProcedure.execute(world, x + ox, y + oy, z + oz, axis);
				}
			}
		} else {
			if (world.getBlockState(BlockPos.containing(x + ox, y + oy, z + oz)).canOcclude() || mini_sprawl >= 3 && Math.random() < 0.13 || lambda <= 0 || mini_sprawl >= 9) {
				if (lambda > 0) {
					if (!world.getBlockState(BlockPos.containing(x + ox, y + oy, z + oz)).canOcclude()) {
						world.setBlock(BlockPos.containing(x + ox, y + oy, z + oz), (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with(EndlessEndModBlocks.JOINT.get().defaultBlockState(), "axis", axis)), 3);
						while (direct == new_direct) {
							new_direct = Direction.getRandom(RandomSource.create());
						}
						if (!(new_direct == Direction.UP)) {
							world.setBlock(BlockPos.containing(x + ox, y + oy + 1, z + oz), Blocks.SCULK_CATALYST.defaultBlockState(), 3);
						}
						BoneSprawlProcedure.execute(world, x + ox, y + oy, z + oz, new_direct, false, lambda - 1, 0);
					}
				} else {
					world.setBlock(BlockPos.containing(x + ox, y + oy, z + oz), (new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.JOINT.get().defaultBlockState(), "axis", axis)), 3);
					BoneSprawlProcedure.execute(world, x + ox, y + oy, z + oz, Direction.DOWN, true, Mth.nextInt(RandomSource.create(), 10, 20), 0);
				}
			} else {
				world.setBlock(BlockPos.containing(x + ox, y + oy, z + oz), (new Object() {
					public BlockState with(BlockState _bs, String _property, String _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
					}
				}.with(EndlessEndModBlocks.VERTABRAE.get().defaultBlockState(), "axis", axis)), 3);
				if (lambda > 0) {
					BoneSprawlProcedure.execute(world, x + ox, y + oy, z + oz, direct, false, lambda - 1, mini_sprawl + 1);
				}
				if (Math.random() < 0.3) {
					SprawlThornsProcedure.execute(world, x + ox, y + oy, z + oz, axis);
				}
				if (Math.random() < 0.15) {
					world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.JOINT.get().defaultBlockState(), 3);
					while (Direction.UP == new_direct || direct == new_direct) {
						new_direct = Direction.getRandom(RandomSource.create());
					}
					BoneSprawlProcedure.execute(world, x, y, z, new_direct, false, lambda - 1, mini_sprawl);
				}
			}
		}
	}
}
