
package net.mcreator.endless_end.potion;

import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.endless_end.procedures.OdorEffectStartedappliedProcedure;

import java.util.Set;

public class OdorMobEffect extends MobEffect {
	public OdorMobEffect() {
		super(MobEffectCategory.HARMFUL, -52378);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		OdorEffectStartedappliedProcedure.execute(entity);
	}
}
