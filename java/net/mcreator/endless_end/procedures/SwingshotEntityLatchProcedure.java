package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;

public class SwingshotEntityLatchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double dx = 0;
		double distance = 0;
		double dy = 0;
		double dz = 0;
		boolean est = false;
		if (entity instanceof LivingEntity || entity instanceof EnderDragon) {
			SwingsilkResetProcedure.execute(world, x, y, z, sourceentity);
			{
				EndlessEndModVariables.PlayerVariables _vars = sourceentity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.SwingsilkX = entity.getX();
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				EndlessEndModVariables.PlayerVariables _vars = sourceentity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.SwingsilkY = entity.getY();
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				EndlessEndModVariables.PlayerVariables _vars = sourceentity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.SwingsilkZ = entity.getZ();
				_vars.syncPlayerVariables(sourceentity);
			}
			dx = sourceentity.getX() - sourceentity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX;
			dy = sourceentity.getY() - sourceentity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY;
			dz = sourceentity.getZ() - sourceentity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ;
			distance = Math.pow(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2), 0.5);
			if (distance < 7) {
				{
					EndlessEndModVariables.PlayerVariables _vars = sourceentity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.SwingsilkDistance = 7;
					_vars.syncPlayerVariables(sourceentity);
				}
			} else {
				{
					EndlessEndModVariables.PlayerVariables _vars = sourceentity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.SwingsilkDistance = distance;
					_vars.syncPlayerVariables(sourceentity);
				}
			}
			{
				EndlessEndModVariables.PlayerVariables _vars = sourceentity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.SwingsilkLinked = true;
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				EndlessEndModVariables.PlayerVariables _vars = sourceentity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.SwingsilkEntity = entity.getStringUUID();
				_vars.syncPlayerVariables(sourceentity);
			}
		}
	}
}
