package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.entity.SwingsilkBallEntity;

import java.util.List;
import java.util.Comparator;

public class SwingsilkPositionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		found = false;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(96 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player && entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkLinked
						&& (entityiterator.getStringUUID()).equals(entity instanceof SwingsilkBallEntity _datEntS ? _datEntS.getEntityData().get(SwingsilkBallEntity.DATA_BoundPlayer) : "")) {
					{
						Entity _ent = entity;
						_ent.teleportTo(entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX, entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY,
								entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX, entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY,
									entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ, _ent.getYRot(), _ent.getXRot());
					}
					{
						Entity _ent = entity;
						_ent.setYRot(0);
						_ent.setXRot(0);
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
					found = true;
				}
			}
		}
		if (!found) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, y, z, 5, 0.1, 0.1, 0.1, 0.1);
		}
	}
}
