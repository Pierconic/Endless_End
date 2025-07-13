package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class EndBoulderConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("end_barrens")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("end_highlands"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("end_midlands")))
				&& ((world.getBlockState(BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) - 1, z))).getBlock() == EndlessEndModBlocks.REFUSE.get()
						|| (world.getBlockState(BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) - 1, z))).getBlock() == Blocks.END_STONE)
				&& ((world.getBlockState(BlockPos.containing(x + 6, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 6), (int) z) - 1, z))).getBlock() == EndlessEndModBlocks.REFUSE.get()
						|| (world.getBlockState(BlockPos.containing(x + 6, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 6), (int) z) - 1, z))).getBlock() == Blocks.END_STONE)) {
			return true;
		}
		return false;
	}
}
