package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;

public class RadianceCondition3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).radiance >= 8 && entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).radiance < 12) {
			return true;
		}
		return false;
	}
}
