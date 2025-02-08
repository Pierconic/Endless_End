package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RadianceRemovalProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(EndlessEndModMobEffects.RADIANCE)) && entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).radiance > 0) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.radiance = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).radiance - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
