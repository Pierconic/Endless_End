package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.entity.SageEntity;

public class SageCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_stun_ticks) : 0) == 0) {
			return true;
		}
		return false;
	}
}
