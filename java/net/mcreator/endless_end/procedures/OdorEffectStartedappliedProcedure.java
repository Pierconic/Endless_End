package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.init.EndlessEndModMobEffects;

public class OdorEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(EndlessEndModMobEffects.FRAGRANCE);
	}
}
