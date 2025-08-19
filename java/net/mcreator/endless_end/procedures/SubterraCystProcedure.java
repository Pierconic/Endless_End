package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SubterraCystProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double bubble_rad = 0;
		double core_rad = 0;
		if (world.getBlockState(BlockPos.containing(x, y - 4, z)).isFaceSturdy(world, BlockPos.containing(x, y - 4, z), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x + 4, y, z)).isFaceSturdy(world, BlockPos.containing(x + 4, y, z), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x - 4, y, z)).isFaceSturdy(world, BlockPos.containing(x - 4, y, z), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x, y, z + 4)).isFaceSturdy(world, BlockPos.containing(x, y, z + 4), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x, y, z - 4)).isFaceSturdy(world, BlockPos.containing(x, y, z - 4), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x, y + 9, z)).isFaceSturdy(world, BlockPos.containing(x, y + 9, z), Direction.UP)) {
			core_rad = Mth.nextInt(RandomSource.create(), 5, 9);
			BlockSphereProcedure.execute(world, x, y, z, EndlessEndModBlocks.GRIM_STONE.get().defaultBlockState(), core_rad + 1, 1, 1, 1);
			for (int index0 = 0; index0 < (int) core_rad; index0++) {
				CystCoreProcedure.execute(world, x, y, z, core_rad, 1, 1, 1);
				core_rad = core_rad - 1;
			}
			world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.COSMIC_DEBRIS.get().defaultBlockState(), 3);
			return true;
		}
		return false;
	}
}
