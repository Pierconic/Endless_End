package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;

public class RadianceActiveTickConditionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).radiance < 48) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.radiance = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).radiance + 4;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
