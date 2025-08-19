package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModEntities;
import net.mcreator.endless_end.entity.HollowEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HollowEntityIsHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity(), event.getOriginalDamage());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double xOff = 0;
		double zOff = 0;
		double jump = 0;
		double distance = 0;
		if (entity instanceof HollowEntity && amount < (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) && !(sourceentity == null)) {
			if (Math.random() < 0.3) {
				RandWarpProcedure.execute(world, sourceentity.getX(), sourceentity.getY(), sourceentity.getZ(), entity, 20);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EndlessEndModEntities.SCULK_WORM.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
		}
	}
}
