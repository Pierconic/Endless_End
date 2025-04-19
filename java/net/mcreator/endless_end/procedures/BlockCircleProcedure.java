package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BlockCircleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState filler, boolean replace, double chance, double radius, double radx, double radz) {
		double counter = 0;
		double x2 = 0;
		double z2 = 0;
		double layer = 0;
		while (counter <= 360) {
			x2 = radx * radius * Math.cos(counter);
			z2 = radz * radius * Math.sin(counter);
			counter = counter + 1;
			if ((!(world.getBlockState(BlockPos.containing(x + x2 + 0.5, y, z + z2 + 0.5))).isCollisionShapeFullBlock(world, BlockPos.containing(0, 0, 0)) || replace) && Math.random() < chance) {
				world.setBlock(BlockPos.containing(x + x2 + 0.5, y, z + z2 + 0.5), filler, 3);
			}
		}
	}
}
