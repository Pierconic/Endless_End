package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class NaturalBoneSprawlProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.VERTABRAE.get().defaultBlockState(), 3);
		BoneSprawlProcedure.execute(world, x, y, z, Direction.UP, false, Mth.nextInt(RandomSource.create(), 15, 25), 2);
		return true;
	}
}
