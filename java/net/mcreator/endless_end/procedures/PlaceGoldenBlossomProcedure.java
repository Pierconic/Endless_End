package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class PlaceGoldenBlossomProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		if (!(48 < VoidHeightProcedure.execute(world, x, z))) {
			world.setBlock(BlockPos.containing(x, VoidGenHeightProcedure.execute(world, x, z) - 1, z), EndlessEndModBlocks.PUFF_BLOSSOM.get().defaultBlockState(), 3);
			return true;
		}
		return false;
	}
}
