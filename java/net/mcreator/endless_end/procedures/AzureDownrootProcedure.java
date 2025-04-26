package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class AzureDownrootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean finished = false;
		double sy = 0;
		double sx = 0;
		double sz = 0;
		world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
		finished = false;
		sy = 0;
		while (!finished && y - sy > -64) {
			if (VoidAccessProcedure.execute(world, x, z, y - sy)) {
				if (sy > 15) {
					world.setBlock(BlockPos.containing(x, y - sy, z), EndlessEndModBlocks.AZURE_SEPAL_LOG.get().defaultBlockState(), 3);
					GoldenStemCheckProcedure.execute(world, x, y - sy, z);
				}
				finished = true;
			} else {
				for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 4); index1++) {
					sx = Mth.nextInt(RandomSource.create(), -1, 1);
					sz = Mth.nextInt(RandomSource.create(), -1, 1);
					if ((world.getBlockState(BlockPos.containing(x + sx, y - sy, z + sx))).getBlock() == Blocks.END_STONE || (world.getBlockState(BlockPos.containing(x + sx, y - sy, z + sx))).getBlock() == EndlessEndModBlocks.COBBLED_ENDSTONE.get()
							|| (world.getBlockState(BlockPos.containing(x + sx, y - sy, z + sx))).getBlock() == EndlessEndModBlocks.STRONG_STONE.get()) {
						world.setBlock(BlockPos.containing(x + sx, y - sy, z + sx), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
					}
				}
				sy = sy + 1;
			}
		}
	}
}
