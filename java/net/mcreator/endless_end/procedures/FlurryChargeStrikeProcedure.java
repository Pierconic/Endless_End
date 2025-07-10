package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.endless_end.entity.FlurryEntity;
import net.mcreator.endless_end.entity.FlurryChargeEntityEntity;

import java.util.List;
import java.util.Comparator;

public class FlurryChargeStrikeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		String shooter = "";
		Entity shooter_entity = null;
		if (!entity.level().isClientSide())
			entity.discard();
		shooter = "none";
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entityiterator.getStringUUID()).equals(entity instanceof FlurryChargeEntityEntity _datEntS ? _datEntS.getEntityData().get(FlurryChargeEntityEntity.DATA_Shooter) : "")) {
					shooter = entityiterator.getStringUUID();
					shooter_entity = entityiterator;
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!((entityiterator.getStringUUID()).equals(entity instanceof FlurryChargeEntityEntity _datEntS ? _datEntS.getEntityData().get(FlurryChargeEntityEntity.DATA_Shooter) : ""))) {
					if (entityiterator instanceof Mob && !("none").equals(shooter)) {
						if (entityiterator instanceof Mob _entity && shooter_entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
					}
					entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 6);
					if (!(entity instanceof FlurryEntity)) {
						entityiterator.setTicksFrozen(280);
					}
				}
			}
		}
		sx = -1;
		for (int index0 = 0; index0 < 3; index0++) {
			sy = -1;
			for (int index1 = 0; index1 < 3; index1++) {
				sz = -1;
				for (int index2 = 0; index2 < 3; index2++) {
					DelayedCrystalProcedure.execute(world, x + sx, y + sy, z + sz, (Math.abs(sx) + Math.abs(sy) + Math.abs(sz)) * 2);
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		DelayedCrystalProcedure.execute(world, x + 2, y + 0, z + 0, 6);
		DelayedCrystalProcedure.execute(world, x - 2, y + 0, z + 0, 6);
		DelayedCrystalProcedure.execute(world, x + 0, y + 0, z + 0, 6);
		DelayedCrystalProcedure.execute(world, x + 0, y + 0, z + 2, 6);
		DelayedCrystalProcedure.execute(world, x + 0, y + 0, z - 2, 6);
		DelayedCrystalProcedure.execute(world, x + 0, y + 2, z - 0, 6);
		DelayedCrystalProcedure.execute(world, x + 0, y - 2, z - 0, 6);
	}
}
