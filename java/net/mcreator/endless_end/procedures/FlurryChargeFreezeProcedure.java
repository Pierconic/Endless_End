package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.Entity;

public class FlurryChargeFreezeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setTicksFrozen(200);
	}
}
