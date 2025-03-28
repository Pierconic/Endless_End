package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;

public class EyeProximityProviderProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double hypotenuse = 0;
		double player_yaw = 0;
		double dx = 0;
		double dz = 0;
		double theta = 0;
		if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation >= 10) {
			dx = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Stronghold_X;
			dz = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Stronghold_Z;
			hypotenuse = Math.sqrt(Math.pow(entity.getX() - dx, 2) + Math.pow(entity.getZ() - dz, 2));
			if (0 < entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).ProximityPower) {
				return 6;
			} else if (hypotenuse < 128) {
				return 3;
			} else if (hypotenuse < 1000) {
				return 2;
			} else {
				return 1;
			}
		} else {
			if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation < 10 && entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation > 5) {
				return 4;
			} else if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation <= 5 && entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation > 0) {
				return 5;
			}
		}
		return 0;
	}
}
