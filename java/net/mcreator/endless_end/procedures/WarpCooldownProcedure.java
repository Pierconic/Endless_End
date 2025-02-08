package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.endless_end.network.EndlessEndModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class WarpCooldownProcedure {
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
		if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Warpcooldown > 0) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.Warpcooldown = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Warpcooldown - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
