package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.entity.HollowEntity;

public class BurrowConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof HollowEntity _datEntI ? _datEntI.getEntityData().get(HollowEntity.DATA_burrow_progress) : 0) > 0) {
			return false;
		}
		return true;
	}
}
