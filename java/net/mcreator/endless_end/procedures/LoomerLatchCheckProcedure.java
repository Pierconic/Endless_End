package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;
import net.mcreator.endless_end.entity.LoomerEntity;

public class LoomerLatchCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if (!(entity instanceof LoomerEntity _datEntL0 && _datEntL0.getEntityData().get(LoomerEntity.DATA_spiraling)) && entity instanceof LoomerEntity _datEntL1 && _datEntL1.getEntityData().get(LoomerEntity.DATA_latched)) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty()) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.MOON_BLOB.get()), x, y, z, 5, 0.2, 0.2, 0.2, 0);
				return false;
			} else {
				return true;
			}
		}
		return true;
	}
}
