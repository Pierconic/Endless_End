package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;

public class ExecuteSphereProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState filler, double radius, double radw, double rady) {
		double counter = 0;
		double x2 = 0;
		double yOff = 0;
		while (counter <= 180) {
			x2 = radw * radius * Math.cos(counter);
			yOff = rady * radius * Math.sin(counter);
			BlockCircleProcedure.execute(world, x, y + yOff, z, filler, x2, 1, 1);
			counter = counter + 1;
		}
	}
}
