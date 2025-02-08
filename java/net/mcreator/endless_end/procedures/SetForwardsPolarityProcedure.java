package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;

public class SetForwardsPolarityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.fowards_polarity = true;
			_vars.syncPlayerVariables(entity);
		}
	}
}
