package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.entity.LoomerEntity;

public class LoomerChaseProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LoomerEntity _datEntL0 && _datEntL0.getEntityData().get(LoomerEntity.DATA_spiraling)) {
			return true;
		}
		return false;
	}
}
