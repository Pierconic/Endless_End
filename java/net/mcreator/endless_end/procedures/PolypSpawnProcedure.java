package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.entity.PolypEntity;

public class PolypSpawnProcedure {
	public static void execute(double y, Entity entity) {
		if (entity == null)
			return;
		if (y < 32) {
			if (entity instanceof PolypEntity animatable)
				animatable.setTexture("inv_polyp_texture");
		}
	}
}
