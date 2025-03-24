package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;

public class EyeDirectionProviderProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double dx = 0;
		double dy = 0;
		double dz = 0;
		double theta = 0;
		double hypotenuse = 0;
		double player_yaw = 0;
		dx = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Stronghold_X;
		dz = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Stronghold_Z;
		hypotenuse = Math.sqrt(Math.pow(entity.getX() - dx, 2) + Math.pow(entity.getZ() - dz, 2));
		theta = Math.asin((entity.getX() - dx) / hypotenuse) * 57.2957795;
		if (entity.getYRot() < 0) {
			player_yaw = entity.getYRot() % (-360);
		} else {
			player_yaw = entity.getYRot() % 360;
		}
		if (entity.getZ() > dz) {
			theta = Math.signum(theta) * 180 - theta;
		}
		player_yaw = player_yaw - theta;
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.EyeballDirection = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (player_yaw < 0) {
			player_yaw = player_yaw + 360;
		}
		if (player_yaw <= 33.75 && player_yaw > 11.25) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 15;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 56.25 && player_yaw > 33.75) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 14;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 78.75 && player_yaw > 56.25) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 13;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 101.25 && player_yaw > 78.75) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 12;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 123.75 && player_yaw > 101.25) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 11;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 146.25 && player_yaw > 123.75) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 10;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 168.75 && player_yaw > 146.25) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 9;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 191.25 && player_yaw > 168.75) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 8;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 213.75 && player_yaw > 191.25) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 7;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 236.25 && player_yaw > 213.75) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 6;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 258.75 && player_yaw > 236.25) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 5;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 281.25 && player_yaw > 258.75) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 4;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 303.75 && player_yaw > 281.25) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 3;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 326.25 && player_yaw > 303.75) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 2;
				_vars.syncPlayerVariables(entity);
			}
		} else if (player_yaw <= 348.75 && player_yaw > 326.25) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.EyeballDirection = 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
