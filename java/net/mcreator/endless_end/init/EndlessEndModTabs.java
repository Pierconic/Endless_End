
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
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(EndlessEndModItems.WARP_CHIP_WHITE.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_RED.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_ORANGE.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_YELLOW.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_LIME.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_GREEN.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_CYAN.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_LIGHT_BLUE.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_BLUE.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_PURPLE.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_MAGENTA.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_PINK.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_BROWN.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_GRAY.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_DARK_GRAY.get());
			tabData.accept(EndlessEndModItems.WARP_CHIP_BLACK.get());
			tabData.accept(EndlessEndModItems.ESSENCE_BUCKET.get());
			tabData.accept(EndlessEndModItems.YEARNING_EYE.get());
			tabData.accept(EndlessEndModItems.EMPTY_EYE.get());
			tabData.accept(EndlessEndModItems.INTRO.get());
			tabData.accept(EndlessEndModItems.ELEGY.get());
			tabData.accept(EndlessEndModItems.ELEVEN_REPAIRED.get());
			tabData.accept(EndlessEndModItems.CHORUS.get());
			tabData.accept(EndlessEndModItems.SWINGSILK.get());
			tabData.accept(EndlessEndModItems.SWING_SHOT.get());
			tabData.accept(EndlessEndModItems.MAGIC_WAND.get());
			tabData.accept(EndlessEndModItems.FLURRY_ROD.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(EndlessEndModItems.INSECT_FLESH.get());
			tabData.accept(EndlessEndModItems.BOTTLED_STARLIGHT.get());
			tabData.accept(EndlessEndModItems.BLAST_BERRIES_1.get());
			tabData.accept(EndlessEndModItems.BLAST_BERRIES_2.get());
			tabData.accept(EndlessEndModItems.BLAST_BERRIES_3.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(EndlessEndModItems.FLURRY_CHARGE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(EndlessEndModBlocks.ADAMANT.get().asItem());
			tabData.accept(EndlessEndModBlocks.SOUL_BULB.get().asItem());
			tabData.accept(EndlessEndModBlocks.BLUE_ROSE.get().asItem());
			tabData.accept(EndlessEndModBlocks.LYDIAN_PETALS.get().asItem());
			tabData.accept(EndlessEndModBlocks.CHORUS_SPROUTS.get().asItem());
			tabData.accept(EndlessEndModBlocks.CHORUS_ROOTS.get().asItem());
			tabData.accept(EndlessEndModBlocks.TREBLE_BLOOM.get().asItem());
			tabData.accept(EndlessEndModItems.TUNE_ROD.get());
			tabData.accept(EndlessEndModBlocks.GOLDEN_SPROUTS.get().asItem());
			tabData.accept(EndlessEndModBlocks.GOLDEN_ROOTS.get().asItem());
			tabData.accept(EndlessEndModBlocks.PUFF_BLOSSOM.get().asItem());
			tabData.accept(EndlessEndModBlocks.SWIRLING_VINES.get().asItem());
			tabData.accept(EndlessEndModBlocks.GOLDEN_HUMUS.get().asItem());
			tabData.accept(EndlessEndModBlocks.CALCIFIED_ENDSTONE.get().asItem());
			tabData.accept(EndlessEndModBlocks.REFUSE.get().asItem());
			tabData.accept(EndlessEndModBlocks.COBBLED_ENDSTONE.get().asItem());
			tabData.accept(EndlessEndModBlocks.ROOTED_ENDSTONE.get().asItem());
			tabData.accept(EndlessEndModBlocks.AMNESOCLAST.get().asItem());
			tabData.accept(EndlessEndModBlocks.DORMANT_ICONOCLAST.get().asItem());
			tabData.accept(EndlessEndModBlocks.END_AMETHYST.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDORITE_ORE.get().asItem());
			tabData.accept(EndlessEndModBlocks.END_IRON.get().asItem());
			tabData.accept(EndlessEndModBlocks.END_DIAMONDS.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRONG_STONE.get().asItem());
			tabData.accept(EndlessEndModBlocks.CANTICLE.get().asItem());
			tabData.accept(EndlessEndModBlocks.PHRYGIA.get().asItem());
			tabData.accept(EndlessEndModBlocks.TALL_PHYRIGIA.get().asItem());
			tabData.accept(EndlessEndModBlocks.ROTTING_END_STONE.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_SEPAL_LEAVES.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_SEPAL_WOOD.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRIPPED_VIOLET_SEPAL_LOG.get().asItem());
			tabData.accept(EndlessEndModBlocks.MOLDERING_PURPUR.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRIPPED_VIOLET_SEPAL_WOOD.get().asItem());
			tabData.accept(EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().asItem());
			tabData.accept(EndlessEndModBlocks.BLOSSOMING_GOLDEN_SEPAL_LEAVES.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_SEPAL_LOG.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_SEPAL_WOOD.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRIPPED_AZURE_SEPAL_LOG.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRIPPED_AZURE_SEPAL_WOOD.get().asItem());
			tabData.accept(EndlessEndModBlocks.WEAVER_NEST.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_THORNS.get().asItem());
			tabData.accept(EndlessEndModBlocks.VERTABRAE.get().asItem());
			tabData.accept(EndlessEndModBlocks.JOINT.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRIPPED_VERTABRAE.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRIPPED_JOINT.get().asItem());
			tabData.accept(EndlessEndModBlocks.WARDING_EYES.get().asItem());
			tabData.accept(EndlessEndModBlocks.BURROWING_THORNS.get().asItem());
			tabData.accept(EndlessEndModBlocks.SPITEFUL_EYE.get().asItem());
			tabData.accept(EndlessEndModBlocks.BURROWING_SPIKE.get().asItem());
			tabData.accept(EndlessEndModBlocks.SOUL_LIGHT.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_STONE.get().asItem());
			tabData.accept(EndlessEndModBlocks.INFESTED_GRIM_STONE.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_STONE_DIAMOND_ORE.get().asItem());
			tabData.accept(EndlessEndModBlocks.COSMIC_DEBRIS.get().asItem());
			tabData.accept(EndlessEndModBlocks.FLOURITE.get().asItem());
			tabData.accept(EndlessEndModBlocks.SPREADING_FLOURITE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(EndlessEndModBlocks.ENDORITE_BLOCK.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDORITE_MESH.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDORITE_CORE.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDORITE_TILES.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDORITE_MEMBRANE.get().asItem());
			tabData.accept(EndlessEndModBlocks.TRANSCEIVER.get().asItem());
			tabData.accept(EndlessEndModItems.TRANSPONDER.get());
			tabData.accept(EndlessEndModBlocks.TUNE_BLOCK.get().asItem());
			tabData.accept(EndlessEndModBlocks.FLOURITE_LAMP.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_SEPAL_BUTTON.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_SEPAL_BUTTON.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_BUTTON.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_TRAPDOOR.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_TRAPDOOR.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_TRAPDOOR.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_DOOR.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_DOOR.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_DOOR.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(EndlessEndModItems.GRAZER_SPAWN_EGG.get());
			tabData.accept(EndlessEndModItems.TRAWLER_SPAWN_EGG.get());
			tabData.accept(EndlessEndModItems.POLYP_SPAWN_EGG.get());
			tabData.accept(EndlessEndModItems.FLURRY_SPAWN_EGG.get());
			tabData.accept(EndlessEndModItems.AMALGAM_SPAWN_EGG.get());
			tabData.accept(EndlessEndModItems.HOLLOW_SPAWN_EGG.get());
			tabData.accept(EndlessEndModItems.SAGE_SPAWN_EGG.get());
			tabData.accept(EndlessEndModItems.LOOMER_SPAWN_EGG.get());
			tabData.accept(EndlessEndModItems.SCULK_WORM_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(EndlessEndModItems.DISC_FRAGMENT_INTRO.get());
			tabData.accept(EndlessEndModItems.MOON_JELLY.get());
			tabData.accept(EndlessEndModItems.RAW_ENDORITE.get());
			tabData.accept(EndlessEndModItems.ENDORITE_INGOT.get());
			tabData.accept(EndlessEndModItems.STRANGE_KEY.get());
			tabData.accept(EndlessEndModItems.WARPED_KEY.get());
			tabData.accept(EndlessEndModItems.BRITTLE_CARAPACE.get());
			tabData.accept(EndlessEndModItems.ELYTRON_SHARD.get());
			tabData.accept(EndlessEndModItems.STAR_FRAGMENT.get());
			tabData.accept(EndlessEndModItems.DISC_FRAGMENT_ELEGY.get());
			tabData.accept(EndlessEndModItems.DISC_FRAGMENT_CHORUS.get());
			tabData.accept(EndlessEndModItems.FLURRY_CHARGE.get());
			tabData.accept(EndlessEndModItems.FLURRY_ROD.get());
			tabData.accept(EndlessEndModBlocks.STRANGE_EGGS.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(EndlessEndModBlocks.CHISELED_ENDSTONE.get().asItem());
			tabData.accept(EndlessEndModBlocks.CRACKED_END_STONE_BRICKS.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_SEPAL_WOOD.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_SEPAL_LOG.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_SEPAL_PLANKS.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_SEPAL_STAIRS.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_SEPAL_SLAB.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_SEPAL_FENCE.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_SEPAL_FENCE_GATE.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_SEPAL_PRESSURE_PLATE.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRIPPED_VIOLET_SEPAL_LOG.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRIPPED_VIOLET_SEPAL_WOOD.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_TRAPDOOR.get().asItem());
			tabData.accept(EndlessEndModBlocks.VIOLET_DOOR.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_SEPAL_LOG.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_SEPAL_WOOD.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_SEPAL_PLANKS.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_SEPAL_STAIRS.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_SEPAL_SLAB.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_SEPAL_FENCE.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_SEPAL_FENCE_GATE.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_SEPAL_PRESSURE_PLATE.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRIPPED_AZURE_SEPAL_LOG.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRIPPED_AZURE_SEPAL_WOOD.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_TRAPDOOR.get().asItem());
			tabData.accept(EndlessEndModBlocks.AZURE_DOOR.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRIPPED_VERTABRAE.get().asItem());
			tabData.accept(EndlessEndModBlocks.STRIPPED_JOINT.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_PLANKS.get().asItem());
			tabData.accept(EndlessEndModBlocks.SOUL_LIGHT.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_STAIRS.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_SLAB.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_FENCE.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_FENCE_GATE.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_PRESSURE_PLATE.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_TRAPDOOR.get().asItem());
			tabData.accept(EndlessEndModBlocks.GRIM_DOOR.get().asItem());
			tabData.accept(EndlessEndModBlocks.COSMIC_BLOCK.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(EndlessEndModBlocks.TETHER.get().asItem());
			tabData.accept(EndlessEndModBlocks.SINGING_SAND.get().asItem());
			tabData.accept(EndlessEndModBlocks.MOON_JELLY_BLOCK.get().asItem());
			tabData.accept(EndlessEndModBlocks.SILK_SPOOL.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_WHITE.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_RED.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_ORANGE.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_YELLOW.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_LIME.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_GREEN.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_CYAN.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_LIGHT_BLUE.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_BLUE.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_PURPLE.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_MAGENTA.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_PINK.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_BROWN.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_LIGHT_GRAY.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_DARK_GRAY.get().asItem());
			tabData.accept(EndlessEndModBlocks.ENDERPORTER_BLACK.get().asItem());
		}
	}
}
