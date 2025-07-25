package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class SculkCoreProcedure {
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
				if (Blocks.SCULK == (world.getBlockState(BlockPos.containing(x, y + yOff + 1, z))).getBlock() || EndlessEndModBlocks.BURROWING_THORNS.get() == (world.getBlockState(BlockPos.containing(x, y + yOff + 1, z))).getBlock()) {
					world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), EndlessEndModBlocks.GRIM_STONE.get().defaultBlockState(), 3);
				} else {
					if (Math.random() < 0.2) {
						if (Math.random() < 0.3) {
							world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), EndlessEndModBlocks.BURROWING_THORNS.get().defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), Blocks.SCULK.defaultBlockState(), 3);
						}
					} else {
						world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), EndlessEndModBlocks.SINGING_SAND.get().defaultBlockState(), 3);
					}
				}
				counter2 = counter2 + 3;
			}
			counter = counter + 3;
		}
	}
}
