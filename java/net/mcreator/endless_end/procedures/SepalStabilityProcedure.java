package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SepalStabilityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() || world.getBlockState(BlockPos.containing(x + 1, y, z - 1)).canOcclude() || world.getBlockState(BlockPos.containing(x + 1, y, z + 1)).canOcclude()
				|| world.getBlockState(BlockPos.containing(x - 1, y, z - 1)).canOcclude() || world.getBlockState(BlockPos.containing(x - 1, y, z + 1)).canOcclude() || world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude()
				|| world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude() || world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude() || world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude()
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.VIOLET_SEPAL_LEAVES.get())) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
		}
	}
}
