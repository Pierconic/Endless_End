package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.endless_end.init.EndlessEndModMobEffects;

public class GrazerMeleeConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.UNLUCK) || entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(EndlessEndModMobEffects.FRAGRANCE)) {
			return false;
		}
		return true;
	}
}
