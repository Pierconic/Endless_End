package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.pathfinder.Target;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModEntities;
import net.mcreator.endless_end.entity.FlurryChargeEntityEntity;

import java.util.Comparator;

public class FlurryChargeFireProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity Target = null;
		boolean found = false;
		double magnitude = 0;
		double distance = 0;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = EndlessEndModEntities.FLURRY_CHARGE_ENTITY.get().spawn(_level, BlockPos.containing(x, y + 1.2, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setDeltaMovement((entity.getLookAngle().x * 2), (entity.getLookAngle().y * 2), (entity.getLookAngle().z * 2));
			}
		}
		if (!world.getEntitiesOfClass(FlurryChargeEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
			if (((Entity) world.getEntitiesOfClass(FlurryChargeEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof FlurryChargeEntityEntity _datEntSetS)
				_datEntSetS.getEntityData().set(FlurryChargeEntityEntity.DATA_Shooter, (entity.getStringUUID()));
		}
	}
}
