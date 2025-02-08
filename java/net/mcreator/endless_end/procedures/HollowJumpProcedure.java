package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.entity.HollowEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HollowJumpProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HollowEntity && HollowLeapTestProcedure.execute(entity)) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + 4 * entity.getLookAngle().x), (entity.getDeltaMovement().y() + 4 * entity.getLookAngle().y), (entity.getDeltaMovement().z() + 4 * entity.getLookAngle().z)));
			if (entity instanceof HollowEntity _datEntSetI)
				_datEntSetI.getEntityData().set(HollowEntity.DATA_jump_cooldown, 60);
		}
	}
}
