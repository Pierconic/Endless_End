package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class AmalgamCollisionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double y_vec = 0;
		double magnitude = 0;
		double x_vec = 0;
		double z_vec = 0;
		if (entity instanceof Player) {
			magnitude = Math.sqrt(Math.pow(entity.getX() - x, 2) + Math.pow(entity.getY() - y, 2) + Math.pow(entity.getZ() - z, 2));
			x_vec = (entity.getX() - x) / magnitude;
			y_vec = ((entity.getY() + 0.7) - y) / magnitude;
			z_vec = (entity.getZ() - z) / magnitude;
			entity.setDeltaMovement(new Vec3((x_vec * 4), (y_vec * 4), (z_vec * 4)));
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), sourceentity), 2);
			sourceentity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + x_vec * (-0.5)), (entity.getDeltaMovement().y() + y_vec * (-0.5)), (entity.getDeltaMovement().z() + z_vec * (-0.5))));
		}
	}
}
