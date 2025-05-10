package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class StrangeEggsShotProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		StrangeEggsBreakProcedure.execute(world, x, y, z, blockstate);
		world.destroyBlock(BlockPos.containing(x, y, z), false);
	}
}
