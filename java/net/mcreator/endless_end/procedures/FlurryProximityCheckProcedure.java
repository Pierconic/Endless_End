package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Blaze;

public class FlurryProximityCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12, 12, 12), e -> true).isEmpty() || !world.getEntitiesOfClass(Blaze.class, AABB.ofSize(new Vec3(x, y, z), 12, 12, 12), e -> true).isEmpty())) {
			return true;
		}
		return false;
	}
}
