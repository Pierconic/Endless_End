package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.endless_end.init.EndlessEndModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EndermiteHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Endermite) {
			if (sourceentity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(EndlessEndModMobEffects.FRAGRANCE)) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.removeEffect(EndlessEndModMobEffects.FRAGRANCE);
			} else {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.ODOR, Mth.nextInt(RandomSource.create(), 400, 800), 0));
			}
		}
	}
}
