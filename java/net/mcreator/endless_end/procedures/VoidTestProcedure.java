package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class VoidTestProcedure {
	public static void execute(LevelAccessor world, double x, double z) {
		world.setBlock(BlockPos.containing(x, VoidHeightProcedure.execute(world, x, z), z), Blocks.DIAMOND_BLOCK.defaultBlockState(), 3);
	}
}
