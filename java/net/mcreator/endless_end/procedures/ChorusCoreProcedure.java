package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class ChorusCoreProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double radius, double radx, double rady, double radz) {
		double counter = 0;
		double x2 = 0;
		double yOff = 0;
		double z2 = 0;
		double localRad = 0;
		double counter2 = 0;
		while (counter <= 180) {
			localRad = radius * Math.cos(counter);
			yOff = rady * radius * Math.sin(counter);
			counter2 = 0;
			while (counter2 <= 360) {
				x2 = radx * localRad * Math.cos(counter2);
				z2 = radz * localRad * Math.sin(counter2);
				if (EndlessEndModBlocks.CANTICLE.get() == (world.getBlockState(BlockPos.containing(x, y + yOff + 1, z))).getBlock()
						|| EndlessEndModBlocks.BLOOMING_CANTICLE.get() == (world.getBlockState(BlockPos.containing(x, y + yOff + 1, z))).getBlock()) {
					world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), EndlessEndModBlocks.ROTTING_END_STONE.get().defaultBlockState(), 3);
				} else {
					if (Math.random() < 0.15) {
						world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), Blocks.END_STONE.defaultBlockState(), 3);
					} else {
						if (Math.random() < 0.05) {
							world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), Blocks.CHORUS_FLOWER.defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), EndlessEndModBlocks.MOLDERING_PURPUR.get().defaultBlockState(), 3);
						}
					}
				}
				counter2 = counter2 + 3;
			}
			counter = counter + 3;
		}
	}
}
