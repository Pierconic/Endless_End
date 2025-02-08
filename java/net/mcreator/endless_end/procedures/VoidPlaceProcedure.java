package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class VoidPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.STRUCTURE_VOID.defaultBlockState(), 3);
		}
	}
}
