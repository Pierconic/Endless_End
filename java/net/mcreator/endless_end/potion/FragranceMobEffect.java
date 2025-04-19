
package net.mcreator.endless_end.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.endless_end.procedures.FragranceSpreadProcedure;
import net.mcreator.endless_end.procedures.FragranceAppliedProcedure;

public class FragranceMobEffect extends MobEffect {
	public FragranceMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -52276);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		FragranceAppliedProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		FragranceSpreadProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
