package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;

public class ResetBlastingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.blast_x = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.blast_y = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.blast_z = 0;
			_vars.syncPlayerVariables(entity);
		}
	}
}
