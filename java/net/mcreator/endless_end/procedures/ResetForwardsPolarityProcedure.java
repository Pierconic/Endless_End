package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;

public class ResetForwardsPolarityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.fowards_polarity = false;
			_vars.syncPlayerVariables(entity);
		}
	}
}
