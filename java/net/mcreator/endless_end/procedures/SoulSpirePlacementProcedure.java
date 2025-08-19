package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;

public class SoulSpirePlacementProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!VoidAccessProcedure.execute(world, x, z, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z))
				&& !VoidAccessProcedure.execute(world, x + 3, z, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 3), (int) z))
				&& !VoidAccessProcedure.execute(world, x - 3, z, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 3), (int) z))
				&& !VoidAccessProcedure.execute(world, x, z - 3, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 3)))
				&& !VoidAccessProcedure.execute(world, x, z + 3, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 3))) && y < 90) {
			SoulPillarProcedure.execute(world, x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) - 2, z);
			return true;
		}
		return false;
	}
}
