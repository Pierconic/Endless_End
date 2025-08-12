package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class BigChorusTreeSegmentProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double amount) {
		double sy = 0;
		double xDir = 0;
		double zDir = 0;
		double branchL = 0;
		double sh = 0;
		for (int index0 = 0; index0 < (int) amount; index0++) {
			if (world.isEmptyBlock(BlockPos.containing(x, y + sy, z))) {
				if (sy / amount > 0.8 || sy / amount > 0.65 && Math.random() < 0.5) {
					world.setBlock(BlockPos.containing(x, y + sy, z), EndlessEndModBlocks.STRIPPED_VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
				} else {
					world.setBlock(BlockPos.containing(x, y + sy, z), EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), 3);
					if (Math.random() < 0.16) {
						sh = 0;
						branchL = Mth.nextInt(RandomSource.create(), 3, 5);
						if (Math.random() < 0.5) {
							xDir = 0;
							if (Math.random() < 0.5) {
								zDir = 1;
							} else {
								zDir = -1;
							}
						} else {
							zDir = 0;
							if (Math.random() < 0.5) {
								xDir = 1;
							} else {
								xDir = -1;
							}
						}
						for (int index1 = 0; index1 < (int) branchL; index1++) {
							if ((world.getBlockState(BlockPos.containing(x + sh * xDir, (y + sy) - 1, z + sh * zDir))).getBlock() == EndlessEndModBlocks.VIOLET_SEPAL_LOG.get()) {
								world.setBlock(BlockPos.containing(x + sh * xDir, y + sy, z + sh * zDir), EndlessEndModBlocks.VIOLET_SEPAL_WOOD.get().defaultBlockState(), 3);
							} else if (xDir == 0) {
								SepallFallProcedure.execute(world, x + sh * xDir, y + sy, z + sh * zDir, 9);
								world.setBlock(BlockPos.containing(x + sh * xDir, y + sy, z + sh * zDir), (new Object() {
									public BlockState with(BlockState _bs, String _property, String _newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
										return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
									}
								}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "z")), 3);
							} else {
								SepallFallProcedure.execute(world, x + sh * xDir, y + sy, z + sh * zDir, 9);
								world.setBlock(BlockPos.containing(x + sh * xDir, y + sy, z + sh * zDir), (new Object() {
									public BlockState with(BlockState _bs, String _property, String _newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
										return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
									}
								}.with(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().defaultBlockState(), "axis", "x")), 3);
							}
							sh = sh + 1;
						}
						world.setBlock(BlockPos.containing(x + sh * xDir, y + sy, z + sh * zDir), EndlessEndModBlocks.VIOLET_SEPAL_WOOD.get().defaultBlockState(), 3);
						VioletShootProcedure.execute(world, x + sh * xDir, y + sy + 1, z + sh * zDir);
					}
				}
			}
			sy = sy + 1;
		}
	}
}
