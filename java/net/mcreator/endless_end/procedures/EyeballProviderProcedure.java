package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;

public class EyeballProviderProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EyeballDirection;
	}
}
