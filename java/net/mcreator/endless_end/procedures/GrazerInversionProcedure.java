package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.entity.GrazerEntity;

public class GrazerInversionProcedure {
	public static void execute(double y, Entity entity) {
		if (entity == null)
			return;
		if (y < 32) {
			if (entity instanceof GrazerEntity animatable)
				animatable.setTexture("grazer_shell_inv");
			if (entity instanceof GrazerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(GrazerEntity.DATA_inverted, true);
		} else {
			if (entity instanceof GrazerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(GrazerEntity.DATA_inverted, false);
		}
	}
}
