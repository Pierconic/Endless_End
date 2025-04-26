package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class VoidGenBlockProcedure {
	public static BlockState execute(LevelAccessor world, double x, double z) {
		double sy = 0;
		BlockState returned_block = Blocks.AIR.defaultBlockState();
		boolean found = false;
		returned_block = Blocks.AIR.defaultBlockState();
		found = false;
		sy = -56;
		while (sy < 128 && !found) {
			if (world.getBlockState(BlockPos.containing(x, sy, z)).canOcclude()) {
				returned_block = (world.getBlockState(BlockPos.containing(x, sy, z)));
				found = true;
			}
			sy = sy + 1;
		}
		return returned_block;
	}
}
