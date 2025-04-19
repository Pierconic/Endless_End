package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class GrazerWanderConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
			return false;
		}
		return true;
	}
}
