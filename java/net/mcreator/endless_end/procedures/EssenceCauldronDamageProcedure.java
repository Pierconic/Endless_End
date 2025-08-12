package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class EssenceCauldronDamageProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getY() - y < 0.5) {
			EssenceLeechProcedure.execute(world, x, y, z, entity);
		}
	}
}
