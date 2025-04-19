package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;
import java.util.Comparator;

public class MagicWardTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getPersistentData().getString("owner")).equals("0")) {
			entity.getPersistentData().putDouble("lifetime", (entity.getPersistentData().getDouble("lifetime") - 1));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if ((entityiterator.getStringUUID()).equals(entity.getPersistentData().getString("owner"))) {
							{
								Entity _ent = entity;
								_ent.teleportTo((entityiterator.getX() + entityiterator.getDeltaMovement().x()), (entityiterator.getY() + 1 + entityiterator.getDeltaMovement().y()), (entityiterator.getZ() + entityiterator.getDeltaMovement().z()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((entityiterator.getX() + entityiterator.getDeltaMovement().x()), (entityiterator.getY() + 1 + entityiterator.getDeltaMovement().y()),
											(entityiterator.getZ() + entityiterator.getDeltaMovement().z()), _ent.getYRot(), _ent.getXRot());
							}
						} else {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x() + (entityiterator.getX() - entity.getX()) * 0.01), (entityiterator.getDeltaMovement().y()),
									(entityiterator.getDeltaMovement().z() + (entityiterator.getZ() - entity.getZ()) * 0.01)));
						}
					}
				}
			}
			if (entity.getPersistentData().getDouble("lifetime") == 0) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
