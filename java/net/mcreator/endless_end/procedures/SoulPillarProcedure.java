package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class SoulPillarProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState filler = Blocks.AIR.defaultBlockState();
		double localRad = 0;
		double counter2 = 0;
		double z2 = 0;
		double x2 = 0;
		double counter = 0;
		double yOff = 0;
		double max_height = 0;
		double initRad = 0;
		double extraLocalRad = 0;
		filler = Blocks.CALCITE.defaultBlockState();
		initRad = 5;
		max_height = Mth.nextInt(RandomSource.create(), 10, 20);
		for (int index0 = 0; index0 < (int) max_height; index0++) {
			world.setBlock(BlockPos.containing(x, y + yOff, z), filler, 3);
			counter2 = 0;
			localRad = Math.min(initRad, max_height - yOff);
			extraLocalRad = localRad;
			for (int index1 = 0; index1 < (int) localRad; index1++) {
				counter2 = 0;
				while (counter2 <= 360) {
					x2 = 1 * extraLocalRad * Math.cos(counter2);
					z2 = 1 * extraLocalRad * Math.sin(counter2);
					world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), filler, 3);
					counter2 = counter2 + 1;
				}
				extraLocalRad = extraLocalRad - 1;
			}
			yOff = yOff + 1;
		}
	}
}
