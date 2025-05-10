package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModBlocks;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class SwingItProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vx = 0;
		double vy = 0;
		double dx = 0;
		double distance = 0;
		double vz = 0;
		double dy = 0;
		double dz = 0;
		double dz1 = 0;
		double dx1 = 0;
		double dy1 = 0;
		double p_off = 0;
		boolean found = false;
		boolean entity_found = false;
		Entity swing_entity = null;
		if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkLinked) {
			if ((entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkEntity).equals("spool")) {
				if (!((world.getBlockState(
						BlockPos.containing(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ)))
						.getBlock() == EndlessEndModBlocks.SILK_SPOOL.get())) {
					SwingsilkResetProcedure.execute(world, x, y, z, entity);
				}
			} else if (!(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkEntity).equals("")) {
				entity_found = false;
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(96 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((entityiterator.getStringUUID()).equals(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkEntity)) {
							swing_entity = entityiterator;
							entity_found = true;
						}
					}
				}
				if (entity_found) {
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.SwingsilkX = swing_entity.getX();
						_vars.syncPlayerVariables(entity);
					}
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.SwingsilkY = swing_entity.getY();
						_vars.syncPlayerVariables(entity);
					}
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.SwingsilkZ = swing_entity.getZ();
						_vars.syncPlayerVariables(entity);
					}
				} else {
					SwingsilkResetProcedure.execute(world, x, y, z, entity);
				}
			}
			dx = x - entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX;
			dy = y - entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY;
			dz = z - entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ;
			distance = Math.pow(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2), 0.5);
			if (distance > entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkDistance * 1.6 && distance > 7 || distance > 96) {
				SwingsilkResetProcedure.execute(world, x, y, z, entity);
			} else if (distance > entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkDistance) {
				dx1 = (dx / distance) * entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkDistance;
				dy1 = (dy / distance) * entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkDistance;
				dz1 = (dz / distance) * entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkDistance;
				vx = entity.getDeltaMovement().x() + (dx1 - dx) / distance;
				vy = entity.getDeltaMovement().y() + (dy1 - dy) / distance;
				vz = entity.getDeltaMovement().z() + (dz1 - dz) / distance;
			} else {
				vx = entity.getDeltaMovement().x();
				vy = entity.getDeltaMovement().y();
				vz = entity.getDeltaMovement().z();
			}
			if (vy > 0) {
				entity.fallDistance = 0;
			}
			entity.setDeltaMovement(new Vec3(vx, vy, vz));
			p_off = 1;
			StringParticlesProcedure.execute(world, entity.getX(), entity.getY() + 1, entity.getZ(), distance, 1.8, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX,
					entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ);
		}
	}
}
