package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;

public class RadianceCondition8Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).radiance >= 28 && entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).radiance < 32) {
			return true;
		}
		return false;
	}
}
