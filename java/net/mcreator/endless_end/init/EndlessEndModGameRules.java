
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class EndlessEndModGameRules {
	public static GameRules.Key<GameRules.IntegerValue> ENDERPORTER_COST;
	public static GameRules.Key<GameRules.BooleanValue> ALLOW_GHOSTING;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		ENDERPORTER_COST = GameRules.register("enderporterCost", GameRules.Category.MISC, GameRules.IntegerValue.create(48));
		ALLOW_GHOSTING = GameRules.register("allowGhosting", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	}
}
