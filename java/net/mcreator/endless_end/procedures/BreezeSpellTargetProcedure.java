package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.EndlessEndMod;

public class BreezeSpellTargetProcedure {
	public static void execute(LevelAccessor world, Entity entity, double radius) {
		if (entity == null)
			return;
		double delay = 0;
		EndlessEndMod.queueServerWork(2, () -> {
			BreezeSpellInitiateProcedure.execute(world, Math.round(entity.getX()), Math.round(entity.getY()), Math.round(entity.getZ()), radius);
		});
	}
}
