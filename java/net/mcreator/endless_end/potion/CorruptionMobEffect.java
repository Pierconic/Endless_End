
package net.mcreator.endless_end.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.endless_end.procedures.CorruptionSpreadProcedure;

public class CorruptionMobEffect extends MobEffect {
	public CorruptionMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777216);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		CorruptionSpreadProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
