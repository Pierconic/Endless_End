package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.entity.HollowEntity;

public class HollowLeapTestProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 35 && (entity instanceof HollowEntity _datEntI ? _datEntI.getEntityData().get(HollowEntity.DATA_jump_cooldown) : 0) == 0
				&& (entity instanceof HollowEntity _datEntI ? _datEntI.getEntityData().get(HollowEntity.DATA_burrow_progress) : 0) == 0) {
			return true;
		}
		return false;
	}
}
