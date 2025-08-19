package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class NodePlacementProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double sy = 0;
		double sx = 0;
		double sz = 0;
		double cutout = 0;
		boolean found = false;
		if (y < 70) {
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 6, 12); index0++) {
				sx = Mth.nextInt(RandomSource.create(), -13, 13);
				sz = Mth.nextInt(RandomSource.create(), -13, 13);
				if ((world.getBlockState(BlockPos.containing(x + sx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + sx), (int) (z + sz)) - 1, z + sz))).getBlock() == Blocks.SCULK
						|| (world.getBlockState(BlockPos.containing(x + sx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + sx), (int) (z + sz)) - 1, z + sz))).getBlock() == EndlessEndModBlocks.GRIM_STONE.get()) {
					for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 2, 6); index1++) {
						world.setBlock(BlockPos.containing(x + sx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + sx), (int) (z + sz)), z + sz), EndlessEndModBlocks.STRIPPED_VERTABRAE.get().defaultBlockState(), 3);
					}
					if (Math.random() < 0.7) {
						world.setBlock(BlockPos.containing(x + sx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + sx), (int) (z + sz)), z + sz), Blocks.SCULK_CATALYST.defaultBlockState(), 3);
					} else {
						world.setBlock(BlockPos.containing(x + sx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + sx), (int) (z + sz)), z + sz),
								(Blocks.SCULK_SHRIEKER.getStateDefinition().getProperty("can_summon") instanceof BooleanProperty _withbp15
										? Blocks.SCULK_SHRIEKER.defaultBlockState().setValue(_withbp15, true)
										: Blocks.SCULK_SHRIEKER.defaultBlockState()),
								3);
					}
				}
			}
			return true;
		}
		return false;
	}
}
