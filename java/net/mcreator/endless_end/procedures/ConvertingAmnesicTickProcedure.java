package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class ConvertingAmnesicTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.005) {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.AMNESOCLAST.get().defaultBlockState()));
			world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.AMNESOCLAST.get().defaultBlockState(), 3);
		}
	}
}
