package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.entity.SageEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SageTextureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double shield_max = 0;
		shield_max = 30;
		if ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_damage) : 0) >= shield_max) {
			if (entity instanceof SageEntity animatable)
				animatable.setTexture("sage_broken");
		} else if ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_damage) : 0) > shield_max * 0.6) {
			if (entity instanceof SageEntity animatable)
				animatable.setTexture("sage_critical");
		} else if ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_damage) : 0) > shield_max * 0.3) {
			if (entity instanceof SageEntity animatable)
				animatable.setTexture("sage_cracked");
		} else if ((entity instanceof SageEntity _datEntI ? _datEntI.getEntityData().get(SageEntity.DATA_shield_damage) : 0) > 0) {
			if (entity instanceof SageEntity animatable)
				animatable.setTexture("sage_slightly_cracked");
		} else {
			if (entity instanceof SageEntity animatable)
				animatable.setTexture("sage");
		}
	}
}
