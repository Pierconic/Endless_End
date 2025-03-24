package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BlockSphereProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState filler, double radius, double radx, double rady, double radz) {
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
				world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), filler, 3);
				counter2 = counter2 + 1;
			}
			counter = counter + 1;
		}
	}
}
