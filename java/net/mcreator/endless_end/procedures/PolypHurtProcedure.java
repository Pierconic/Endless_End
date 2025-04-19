package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.endless_end.init.EndlessEndModMobEffects;

public class PolypHurtProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(EndlessEndModMobEffects.FRAGRANCE)) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.removeEffect(EndlessEndModMobEffects.FRAGRANCE);
		} else {
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.ODOR, Mth.nextInt(RandomSource.create(), 1200, 1800), 0));
		}
	}
}
