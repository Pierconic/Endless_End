package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SculkCrownProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.SOUL_LIGHT.get().defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x + 1, y, z + 1), Blocks.SCULK.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), Blocks.SCULK.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x - 1, y, z - 1), Blocks.SCULK.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x - 1, y + 1, z - 1), Blocks.SCULK.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x - 1, y, z + 1), Blocks.SCULK.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x - 1, y + 1, z + 1), Blocks.SCULK.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x + 1, y, z - 1), Blocks.SCULK.defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x + 1, y + 1, z - 1), Blocks.SCULK.defaultBlockState(), 3);
		SculkFallProcedure.execute(world, x + 1, y, z, 8);
		SculkFallProcedure.execute(world, x + -1, y, z, 8);
		SculkFallProcedure.execute(world, x, y, z + -1, 8);
		SculkFallProcedure.execute(world, x, y, z + 1, 8);
	}
}
