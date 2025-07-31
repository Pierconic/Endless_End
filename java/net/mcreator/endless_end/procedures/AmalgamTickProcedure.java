package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class AmalgamTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		boolean lost = false;
		boolean strike = false;
		double baseMult = 0;
		double distance = 0;
		double y_vec = 0;
		double inaccuracy = 0;
		double magnitude = 0;
		double x_vec = 0;
		double z_vec = 0;
		double base_magnitude = 0;
		Entity target = null;
		entity.setNoGravity(true);
		inaccuracy = 15;
		baseMult = 0.2;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48, 48, 48), e -> true).isEmpty()) {
			target = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48, 48, 48), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null);
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).isEmpty()) {
				magnitude = Math.sqrt(Math.pow(x - target.getX(), 2) + Math.pow(y - (target.getY() - 1), 2) + Math.pow(z - target.getZ(), 2));
				base_magnitude = Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().y(), 2) + Math.pow(entity.getDeltaMovement().z(), 2));
			} else {
				magnitude = Math.sqrt(Math.pow(target.getX() - x, 2) + Math.pow(target.getY() - y, 2) + Math.pow(target.getZ() - z, 2));
				base_magnitude = Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().y(), 2) + Math.pow(entity.getDeltaMovement().z(), 2));
			}
			x_vec = (target.getX() - x) / magnitude;
			y_vec = (target.getY() - y) / magnitude;
			z_vec = (target.getZ() - z) / magnitude;
			if (entity.getDeltaMovement().x() != 0) {
				x_vec = (x_vec + (entity.getDeltaMovement().x() / base_magnitude) * inaccuracy) / (inaccuracy + 1);
			}
			if (entity.getDeltaMovement().y() != 0) {
				y_vec = (y_vec + (entity.getDeltaMovement().y() / base_magnitude) * inaccuracy) / (inaccuracy + 1);
			}
			if (entity.getDeltaMovement().z() != 0) {
				z_vec = (z_vec + (entity.getDeltaMovement().z() / base_magnitude) * inaccuracy) / (inaccuracy + 1);
			}
			entity.setDeltaMovement(new Vec3((x_vec * baseMult), (y_vec * baseMult), (z_vec * baseMult)));
		} else {
			entity.setDeltaMovement(new Vec3(0, 0, 0));
		}
	}
}
