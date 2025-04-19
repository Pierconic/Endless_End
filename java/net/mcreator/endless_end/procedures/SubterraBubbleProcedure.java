package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SubterraBubbleProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double bubble_rad = 0;
		double core_rad = 0;
		if (world.getBlockState(BlockPos.containing(x, y - 6, z)).isFaceSturdy(world, BlockPos.containing(x, y - 6, z), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x + 6, y, z)).isFaceSturdy(world, BlockPos.containing(x + 6, y, z), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x - 6, y, z)).isFaceSturdy(world, BlockPos.containing(x - 6, y, z), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x, y, z + 6)).isFaceSturdy(world, BlockPos.containing(x, y, z + 6), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x, y, z - 6)).isFaceSturdy(world, BlockPos.containing(x, y, z - 6), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x, y + 9, z)).isFaceSturdy(world, BlockPos.containing(x, y + 9, z), Direction.UP)) {
			bubble_rad = Mth.nextInt(RandomSource.create(), 5, 9);
			for (int index0 = 0; index0 < (int) bubble_rad; index0++) {
				ChorusCoreProcedure.execute(world, x, y, z, core_rad, 1, 1, 1);
				core_rad = core_rad - 1;
			}
			return true;
		}
		return false;
	}
}
