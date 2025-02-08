package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class CorruptOverlayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) && (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) < 20) {
			return true;
		}
		return false;
	}
}
