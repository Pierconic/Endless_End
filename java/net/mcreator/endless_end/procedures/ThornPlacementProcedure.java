package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class ThornPlacementProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level0 && _level0.isLoaded(BlockPos.containing(x, y, z)) && world instanceof ServerLevel _level1 && _level1.isLoaded(BlockPos.containing(x + 20, y, z)) && world instanceof ServerLevel _level2
				&& _level2.isLoaded(BlockPos.containing(x - 20, y, z)) && world instanceof ServerLevel _level3 && _level3.isLoaded(BlockPos.containing(x, y, z - 20)) && world instanceof ServerLevel _level4
				&& _level4.isLoaded(BlockPos.containing(x, y, z + 20))) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.END_STONE.defaultBlockState(), 3);
			SideWinderPlacementProcedure.execute(world, x, y - Mth.nextInt(RandomSource.create(), 8, 24), z);
		}
	}
}
