
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
	public static GameRules.Key<GameRules.BooleanValue> DO_CUSTOM_STRUCTURES;
	public static GameRules.Key<GameRules.BooleanValue> TICK_GENBLOCKS;
	public static GameRules.Key<GameRules.IntegerValue> ENDERPORTER_COST;
	public static GameRules.Key<GameRules.BooleanValue> ALLOW_GHOSTING;
	public static GameRules.Key<GameRules.IntegerValue> MIN_STRUCTURE_DISTANCE;
	public static GameRules.Key<GameRules.BooleanValue> DEBUG_MODE;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		DO_CUSTOM_STRUCTURES = GameRules.register("doCustomStructures", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
		TICK_GENBLOCKS = GameRules.register("tickGenblocks", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
		ENDERPORTER_COST = GameRules.register("enderporterCost", GameRules.Category.MISC, GameRules.IntegerValue.create(48));
		ALLOW_GHOSTING = GameRules.register("allowGhosting", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
		MIN_STRUCTURE_DISTANCE = GameRules.register("minStructureDistance", GameRules.Category.MISC, GameRules.IntegerValue.create(85));
		DEBUG_MODE = GameRules.register("debugMode", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	}
}
