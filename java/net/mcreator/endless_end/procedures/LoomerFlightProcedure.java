package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.entity.LoomerEntity;

import java.util.List;
import java.util.Comparator;

public class LoomerFlightProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean success = false;
		double height = 0;
		if (LoomerFlightConditionProcedure.execute(world, x, y, z)) {
			height = FlightHeightProcedure.execute(world, x, y, z);
			if (height < 14 || VoidAccessProcedure.execute(world, x, z, y) && y < 72) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.05, (entity.getDeltaMovement().z())));
			} else if (height > 28) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-0.05), (entity.getDeltaMovement().z())));
			}
		} else {
			entity.setDeltaMovement(new Vec3(0, 0, 0));
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12, 12, 12), e -> true).isEmpty() && 50 > (entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0)) {
			if (entity instanceof LoomerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(LoomerEntity.DATA_awareness, (int) ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) + 1));
		} else if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 0) {
			if (entity instanceof LoomerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(LoomerEntity.DATA_awareness, (int) ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) - 1));
		}
		if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 45) {
			success = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof LoomerEntity) && !world.getEntitiesOfClass(LoomerEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY() - 2), (entityiterator.getZ())), 1, 1, 1), e -> true).isEmpty()
							&& entityiterator.getY() > y + 3) {
						LoomerLaunchProcedure.execute(world, x, y, z, entityiterator);
						success = true;
					}
				}
			}
		}
		if (success) {
			if (entity instanceof LoomerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(LoomerEntity.DATA_awareness, (int) ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) - 20));
		}
		if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 30) {
			if (entity instanceof LoomerEntity animatable)
				animatable.setTexture("loomer_shell_5");
		} else if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 25) {
			if (entity instanceof LoomerEntity animatable)
				animatable.setTexture("loomer_shell_4");
		} else if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 20) {
			if (entity instanceof LoomerEntity animatable)
				animatable.setTexture("loomer_shell_3");
		} else if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 15) {
			if (entity instanceof LoomerEntity animatable)
				animatable.setTexture("loomer_shell_2");
		} else if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 10) {
			if (entity instanceof LoomerEntity animatable)
				animatable.setTexture("loomer_shell_1");
		} else {
			if (entity instanceof LoomerEntity animatable)
				animatable.setTexture("loomer_shell");
		}
	}
}
