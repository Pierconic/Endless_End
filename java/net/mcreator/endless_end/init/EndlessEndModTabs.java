
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.EndlessEndMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class EndlessEndModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EndlessEndMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {

			tabData.accept(EndlessEndModBlocks.CHISELED_ENDSTONE.get().asItem());
			tabData.accept(EndlessEndModBlocks.CRACKED_END_STONE_BRICKS.get().asItem());

		} else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {

			tabData.accept(EndlessEndModBlocks.ENDORITE_BLOCK.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDORITE_MESH.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDORITE_CORE.get().asItem());
			tabData.accept(EndlessEndModBlocks.TRANSCEIVER.get().asItem());
			tabData.accept(EndlessEndModItems.TRANSPONDER.get());
			tabData.accept(EndlessEndModBlocks.ENDORITE_TILES.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDORITE_MEMBRANE.get().asItem());
			tabData.accept(EndlessEndModBlocks.TUNE_BLOCK.get().asItem());

		} else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {

			tabData.accept(EndlessEndModBlocks.ENDERPORTER_WHITE.get().asItem());
			tabData.accept(EndlessEndModItems.WARP_CHIP_WHITE.get());
			tabData.accept(EndlessEndModBlocks.TETHER.get().asItem());
			tabData.accept(EndlessEndModBlocks.SINGING_SAND.get().asItem());

		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {

			tabData.accept(EndlessEndModItems.GRAZER_SPAWN_EGG.get());
			tabData.accept(EndlessEndModItems.HOLLOW_SPAWN_EGG.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {

			tabData.accept(EndlessEndModItems.DISC_FRAGMENT_INTRO.get());
			tabData.accept(EndlessEndModItems.RAW_ENDORITE.get());
			tabData.accept(EndlessEndModItems.ENDORITE_INGOT.get());
			tabData.accept(EndlessEndModItems.ELYTRON_SHARD.get());
			tabData.accept(EndlessEndModItems.BRITTLE_CARAPACE.get());
			tabData.accept(EndlessEndModItems.STAR_FRAGMENT.get());
			tabData.accept(EndlessEndModItems.MOON_JELLY.get());
			tabData.accept(EndlessEndModItems.DISC_FRAGMENT_ELEGY.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

			tabData.accept(EndlessEndModItems.INTRO.get());
			tabData.accept(EndlessEndModItems.ESSENCE_BUCKET.get());
			tabData.accept(EndlessEndModItems.MAGIC_WHISTLE.get());
			tabData.accept(EndlessEndModItems.ELEGY.get());
			tabData.accept(EndlessEndModItems.YEARNING_EYE.get());
			tabData.accept(EndlessEndModItems.EMPTY_EYE.get());
			tabData.accept(EndlessEndModItems.ELEVEN_REPAIRED.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {

			tabData.accept(EndlessEndModBlocks.ENDORITE_ORE.get().asItem());
			tabData.accept(EndlessEndModBlocks.END_IRON.get().asItem());
			tabData.accept(EndlessEndModBlocks.CANTICLE.get().asItem());
			tabData.accept(EndlessEndModBlocks.ROTTING_END_STONE.get().asItem());
			tabData.accept(EndlessEndModBlocks.LYDIAN_PETALS.get().asItem());
			tabData.accept(EndlessEndModBlocks.VERTABRAE.get().asItem());
			tabData.accept(EndlessEndModBlocks.ADAMANT.get().asItem());
			tabData.accept(EndlessEndModBlocks.TUNEROD_STEM.get().asItem());
			tabData.accept(EndlessEndModBlocks.SOUL_BULB.get().asItem());
			tabData.accept(EndlessEndModBlocks.BLUE_ROSE.get().asItem());
			tabData.accept(EndlessEndModBlocks.AMNESOCLAST.get().asItem());
			tabData.accept(EndlessEndModBlocks.DORMANT_ICONOCLAST.get().asItem());
			tabData.accept(EndlessEndModBlocks.END_AMETHYST.get().asItem());
			tabData.accept(EndlessEndModBlocks.REFUSE.get().asItem());
			tabData.accept(EndlessEndModBlocks.COBBLED_ENDSTONE.get().asItem());
			tabData.accept(EndlessEndModBlocks.END_DIAMONDS.get().asItem());

		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {

			tabData.accept(EndlessEndModItems.INSECT_FLESH.get());
			tabData.accept(EndlessEndModItems.BOTTLED_STARLIGHT.get());

		}
	}
}
