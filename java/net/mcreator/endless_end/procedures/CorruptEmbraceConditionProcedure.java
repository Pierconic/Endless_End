package net.mcreator.endless_end.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.init.EndlessEndModMobEffects;

public class CorruptEmbraceConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(EndlessEndModMobEffects.CORRUPTION) && !(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			return true;
		}
		return false;
	}
}
