package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;

public class SwingShotPropertyValueProviderProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkLinked) {
			return 1;
		}
		return 0;
	}
}
