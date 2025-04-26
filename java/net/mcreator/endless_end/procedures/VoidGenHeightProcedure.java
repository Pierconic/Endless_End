package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class VoidGenHeightProcedure {
	public static double execute(LevelAccessor world, double x, double z) {
		double sy = 0;
		BlockState returned_block = Blocks.AIR.defaultBlockState();
		boolean found = false;
		sy = -56;
		found = false;
		while (sy < 128 && !found) {
			if (world.getBlockState(BlockPos.containing(x, sy, z)).canOcclude()) {
				found = true;
			} else {
				sy = sy + 1;
			}
		}
		return sy;
	}
}
