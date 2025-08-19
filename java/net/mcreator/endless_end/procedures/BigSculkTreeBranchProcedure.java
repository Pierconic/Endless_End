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

public class BigSculkTreeBranchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction dir, double lambda) {
		if (dir == null)
			return;
		double ox = 0;
		double oz = 0;
		double oy = 0;
		double length = 0;
		double off = 0;
		String enum_axis = "";
		Direction newDir = Direction.NORTH;
		ox = 0;
		oz = 0;
		oy = 0;
		off = 1;
		if (dir == Direction.EAST) {
			ox = 1;
			enum_axis = "x";
		} else if (dir == Direction.WEST) {
			ox = -1;
			enum_axis = "x";
		} else if (dir == Direction.NORTH) {
			oz = -1;
			enum_axis = "z";
		} else if (dir == Direction.SOUTH) {
			enum_axis = "z";
			oz = 1;
		} else {
			enum_axis = "y";
			oy = 1;
		}
		if (oy == 1) {
			length = Mth.nextInt(RandomSource.create(), 8, 24);
		} else {
			length = Mth.nextInt(RandomSource.create(), 3, 6);
		}
		for (int index0 = 0; index0 < (int) length; index0++) {
			world.setBlock(BlockPos.containing(x + ox * off, y + oy * off, z + oz * off), (new Object() {
				public BlockState with(BlockState _bs, String _property, String _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
				}
			}.with(EndlessEndModBlocks.STRIPPED_VERTABRAE.get().defaultBlockState(), "axis", enum_axis)), 3);
			if (Math.random() < 0.1 && dir == Direction.UP) {
				if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z)) && Math.random() < 0.5) {
					world.setBlock(BlockPos.containing(x + ox * off + 1, y + oy * off, z + oz * off), (new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.STRIPPED_VERTABRAE.get().defaultBlockState(), "axis", "x")), 3);
					SculkFallProcedure.execute(world, x + ox * off + 1, y + oy * off, z + oz * off, 8);
				}
				if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z)) && Math.random() < 0.5) {
					world.setBlock(BlockPos.containing((x + ox * off) - 1, y + oy * off, z + oz * off), (new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.STRIPPED_VERTABRAE.get().defaultBlockState(), "axis", "x")), 3);
					SculkFallProcedure.execute(world, (x + ox * off) - 1, y + oy * off, z + oz * off, 8);
				}
				if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1)) && Math.random() < 0.5) {
					world.setBlock(BlockPos.containing(x + ox * off, y + oy * off, z + oz * off + 1), (new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.STRIPPED_VERTABRAE.get().defaultBlockState(), "axis", "z")), 3);
					SculkFallProcedure.execute(world, x + ox * off, y + oy * off, z + oz * off + 1, 8);
				}
				if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) && Math.random() < 0.5) {
					world.setBlock(BlockPos.containing(x + ox * off, y + oy * off, (z + oz * off) - 1), (new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.STRIPPED_VERTABRAE.get().defaultBlockState(), "axis", "z")), 3);
					SculkFallProcedure.execute(world, x + ox * off, y + oy * off, (z + oz * off) - 1, 8);
				}
			} else if (Math.random() < 0.7 && dir == Direction.UP || Math.random() < 0.3) {
				VeinifyProcedure.execute(world, x + ox * off, y + oy * off, z + oz * off);
			} else {
				SculkFallProcedure.execute(world, x + ox * off, y + oy * off, z + oz * off, 4);
			}
			off = off + 1;
		}
		world.setBlock(BlockPos.containing(x + ox * off, y + oy * off, z + oz * off), (new Object() {
			public BlockState with(BlockState _bs, String _property, String _newValue) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
				return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
			}
		}.with(EndlessEndModBlocks.STRIPPED_JOINT.get().defaultBlockState(), "axis", enum_axis)), 3);
		if (dir == Direction.UP) {
			SculkCrownProcedure.execute(world, x + ox * off, y + oy * off, z + oz * off);
		} else {
			if (lambda <= 0) {
				newDir = Direction.UP;
			} else {
				newDir = dir;
				while (newDir == dir || newDir == Direction.DOWN) {
					newDir = Direction.getRandom(RandomSource.create());
				}
			}
			BigSculkTreeBranchProcedure.execute(world, x + ox * off, y + oy * off, z + oz * off, newDir, lambda - 1);
		}
	}
}
