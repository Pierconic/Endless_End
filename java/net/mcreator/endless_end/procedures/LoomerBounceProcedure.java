package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.entity.LoomerEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LoomerBounceProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(LoomerEntity.class, AABB.ofSize(new Vec3(x, (y - 1), z), 1, 1, 1), e -> true).isEmpty()) {
			if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 30) {
				LoomerLaunchProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
