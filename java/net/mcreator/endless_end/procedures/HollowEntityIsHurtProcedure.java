package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.entity.HollowEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HollowEntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity(), event.getOriginalDamage());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double xOff = 0;
		double zOff = 0;
		double jump = 0;
		double distance = 0;
		if (entity instanceof HollowEntity && amount < (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) && !(sourceentity == null)) {
			if (Math.random() < 0.3) {
				RandWarpProcedure.execute(world, sourceentity.getX(), sourceentity.getY(), sourceentity.getZ(), entity, 20);
			}
		}
	}
}
