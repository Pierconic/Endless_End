package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ChorusBubbleProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double bubble_rad = 0;
		double core_rad = 0;
		if (world.getBlockState(BlockPos.containing(x, y - 2, z)).isFaceSturdy(world, BlockPos.containing(x, y - 2, z), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x + 3, y - 2, z)).isFaceSturdy(world, BlockPos.containing(x + 3, y - 2, z), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x - 3, y - 2, z)).isFaceSturdy(world, BlockPos.containing(x - 3, y - 2, z), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x, y - 2, z - 3)).isFaceSturdy(world, BlockPos.containing(x, y - 2, z - 3), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x, y - 2, z + 3)).isFaceSturdy(world, BlockPos.containing(x, y - 2, z + 3), Direction.UP)
				&& world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:chorus_orchard"))) {
			bubble_rad = Mth.nextInt(RandomSource.create(), 4, 11);
			ChorusShellProcedure.execute(world, x, y, z, bubble_rad, 1, 1, 1);
			core_rad = bubble_rad - 1;
			for (int index0 = 0; index0 < (int) bubble_rad; index0++) {
				ChorusCoreProcedure.execute(world, x, y, z, core_rad, 1, 1, 1);
				core_rad = core_rad - 1;
			}
			return true;
		}
		return false;
	}
}
