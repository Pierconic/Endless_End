package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class WellDestructionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.END_PORTAL) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			WellDestructionProcedure.execute(world, x + 1, y, z);
			WellDestructionProcedure.execute(world, x - 1, y, z);
			WellDestructionProcedure.execute(world, x, y, z - 1);
			WellDestructionProcedure.execute(world, x, y, z + 1);
		}
	}
}
