package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class GenericScatterProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState thrown_block = Blocks.AIR.defaultBlockState();
		double ox = 0;
		double oz = 0;
		double oy = 0;
		boolean placed = false;
		thrown_block = (world.getBlockState(BlockPos.containing(x, y, z)));
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		ox = x + Mth.nextInt(RandomSource.create(), -12, 12);
		oz = z + Mth.nextInt(RandomSource.create(), -12, 12);
		oy = y + 10;
		while (oy > -64 && !placed) {
			if (world.getBlockFloorHeight(BlockPos.containing(ox, oy, oz)) > 0) {
				if (world.isEmptyBlock(BlockPos.containing(ox, oy + 1, oz))) {
					world.setBlock(BlockPos.containing(ox, oy + 1, oz), thrown_block, 3);
					placed = true;
				} else {
					placed = true;
				}
			} else {
				oy = oy - 1;
			}
		}
	}
}
