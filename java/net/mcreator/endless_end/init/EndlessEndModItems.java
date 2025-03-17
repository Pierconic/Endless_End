
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.endless_end.procedures.EyeballProviderProcedure;
import net.mcreator.endless_end.procedures.EyeProximityProviderProcedure;
import net.mcreator.endless_end.item.YearningEyeItem;
import net.mcreator.endless_end.item.WarpChipYellowItem;
import net.mcreator.endless_end.item.WarpChipWhiteItem;
import net.mcreator.endless_end.item.WarpChipRedItem;
import net.mcreator.endless_end.item.WarpChipPurpleItem;
import net.mcreator.endless_end.item.WarpChipPinkItem;
import net.mcreator.endless_end.item.WarpChipOrangeItem;
import net.mcreator.endless_end.item.WarpChipMagentaItem;
import net.mcreator.endless_end.item.WarpChipLimeItem;
import net.mcreator.endless_end.item.WarpChipLightBlueItem;
import net.mcreator.endless_end.item.WarpChipGreenItem;
import net.mcreator.endless_end.item.WarpChipGrayItem;
import net.mcreator.endless_end.item.WarpChipDarkGrayItem;
import net.mcreator.endless_end.item.WarpChipCyanItem;
import net.mcreator.endless_end.item.WarpChipBrownItem;
import net.mcreator.endless_end.item.WarpChipBlueItem;
import net.mcreator.endless_end.item.WarpChipBlackItem;
import net.mcreator.endless_end.item.TransponderItem;
import net.mcreator.endless_end.item.StarFragmentItem;
import net.mcreator.endless_end.item.SendingTransponderItem;
import net.mcreator.endless_end.item.RawEndoriteItem;
import net.mcreator.endless_end.item.PulsingTransponderItem;
import net.mcreator.endless_end.item.MoonJellyItem;
import net.mcreator.endless_end.item.MagicWhistleItem;
import net.mcreator.endless_end.item.IntroItem;
import net.mcreator.endless_end.item.InsectFleshItem;
import net.mcreator.endless_end.item.EssenceItem;
import net.mcreator.endless_end.item.EndoriteIngotItem;
import net.mcreator.endless_end.item.EmptyEyeItem;
import net.mcreator.endless_end.item.ElytronShardItem;
import net.mcreator.endless_end.item.ElevenRepairedItem;
import net.mcreator.endless_end.item.ElegyItem;
import net.mcreator.endless_end.item.DiscFragmentIntroItem;
import net.mcreator.endless_end.item.DiscFragmentElegyItem;
import net.mcreator.endless_end.item.BrittleCarapaceItem;
import net.mcreator.endless_end.item.BottledStarlightItem;
import net.mcreator.endless_end.block.display.TetherDisplayItem;
import net.mcreator.endless_end.EndlessEndMod;

public class EndlessEndModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(EndlessEndMod.MODID);
	public static final DeferredItem<Item> DISC_FRAGMENT_INTRO = REGISTRY.register("disc_fragment_intro", DiscFragmentIntroItem::new);
	public static final DeferredItem<Item> CHISELED_ENDSTONE = block(EndlessEndModBlocks.CHISELED_ENDSTONE);
	public static final DeferredItem<Item> CRACKED_END_STONE_BRICKS = block(EndlessEndModBlocks.CRACKED_END_STONE_BRICKS);
	public static final DeferredItem<Item> ENDORITE_ORE = block(EndlessEndModBlocks.ENDORITE_ORE);
	public static final DeferredItem<Item> END_IRON = block(EndlessEndModBlocks.END_IRON);
	public static final DeferredItem<Item> RAW_ENDORITE = REGISTRY.register("raw_endorite", RawEndoriteItem::new);
	public static final DeferredItem<Item> ENDORITE_INGOT = REGISTRY.register("endorite_ingot", EndoriteIngotItem::new);
	public static final DeferredItem<Item> ELYTRON_SHARD = REGISTRY.register("elytron_shard", ElytronShardItem::new);
	public static final DeferredItem<Item> ENDORITE_BLOCK = block(EndlessEndModBlocks.ENDORITE_BLOCK);
	public static final DeferredItem<Item> DISSIPATING_ENDORITE = block(EndlessEndModBlocks.DISSIPATING_ENDORITE);
	public static final DeferredItem<Item> ENDORITE_MESH = block(EndlessEndModBlocks.ENDORITE_MESH);
	public static final DeferredItem<Item> PHASED_ENDORITE_MESH = block(EndlessEndModBlocks.PHASED_ENDORITE_MESH);
	public static final DeferredItem<Item> ENDORITE_CORE = block(EndlessEndModBlocks.ENDORITE_CORE);
	public static final DeferredItem<Item> SENSING_ENDORITE_CORE = block(EndlessEndModBlocks.SENSING_ENDORITE_CORE);
	public static final DeferredItem<Item> TRANSCEIVER = block(EndlessEndModBlocks.TRANSCEIVER);
	public static final DeferredItem<Item> TRANSCEIVER_SENDING_OFF = block(EndlessEndModBlocks.TRANSCEIVER_SENDING_OFF);
	public static final DeferredItem<Item> TRANSCEIVER_SENDING_ON = block(EndlessEndModBlocks.TRANSCEIVER_SENDING_ON);
	public static final DeferredItem<Item> TRANSCEIVER_RECIEVING_ON = block(EndlessEndModBlocks.TRANSCEIVER_RECIEVING_ON);
	public static final DeferredItem<Item> TRANSPONDER = REGISTRY.register("transponder", TransponderItem::new);
	public static final DeferredItem<Item> PULSING_TRANSPONDER = REGISTRY.register("pulsing_transponder", PulsingTransponderItem::new);
	public static final DeferredItem<Item> ENDERPORTER_WHITE = block(EndlessEndModBlocks.ENDERPORTER_WHITE);
	public static final DeferredItem<Item> WARP_CHIP_WHITE = REGISTRY.register("warp_chip_white", WarpChipWhiteItem::new);
	public static final DeferredItem<Item> WARP_CHIP_RED = REGISTRY.register("warp_chip_red", WarpChipRedItem::new);
	public static final DeferredItem<Item> WARP_CHIP_ORANGE = REGISTRY.register("warp_chip_orange", WarpChipOrangeItem::new);
	public static final DeferredItem<Item> WARP_CHIP_YELLOW = REGISTRY.register("warp_chip_yellow", WarpChipYellowItem::new);
	public static final DeferredItem<Item> WARP_CHIP_LIME = REGISTRY.register("warp_chip_lime", WarpChipLimeItem::new);
	public static final DeferredItem<Item> WARP_CHIP_GREEN = REGISTRY.register("warp_chip_green", WarpChipGreenItem::new);
	public static final DeferredItem<Item> WARP_CHIP_CYAN = REGISTRY.register("warp_chip_cyan", WarpChipCyanItem::new);
	public static final DeferredItem<Item> WARP_CHIP_LIGHT_BLUE = REGISTRY.register("warp_chip_light_blue", WarpChipLightBlueItem::new);
	public static final DeferredItem<Item> WARP_CHIP_BLUE = REGISTRY.register("warp_chip_blue", WarpChipBlueItem::new);
	public static final DeferredItem<Item> WARP_CHIP_PURPLE = REGISTRY.register("warp_chip_purple", WarpChipPurpleItem::new);
	public static final DeferredItem<Item> WARP_CHIP_MAGENTA = REGISTRY.register("warp_chip_magenta", WarpChipMagentaItem::new);
	public static final DeferredItem<Item> WARP_CHIP_PINK = REGISTRY.register("warp_chip_pink", WarpChipPinkItem::new);
	public static final DeferredItem<Item> WARP_CHIP_BROWN = REGISTRY.register("warp_chip_brown", WarpChipBrownItem::new);
	public static final DeferredItem<Item> WARP_CHIP_GRAY = REGISTRY.register("warp_chip_gray", WarpChipGrayItem::new);
	public static final DeferredItem<Item> WARP_CHIP_DARK_GRAY = REGISTRY.register("warp_chip_dark_gray", WarpChipDarkGrayItem::new);
	public static final DeferredItem<Item> WARP_CHIP_BLACK = REGISTRY.register("warp_chip_black", WarpChipBlackItem::new);
	public static final DeferredItem<Item> ENDERPORTER_RED = block(EndlessEndModBlocks.ENDERPORTER_RED);
	public static final DeferredItem<Item> ENDERPORTER_ORANGE = block(EndlessEndModBlocks.ENDERPORTER_ORANGE);
	public static final DeferredItem<Item> ENDERPORTER_YELLOW = block(EndlessEndModBlocks.ENDERPORTER_YELLOW);
	public static final DeferredItem<Item> ENDERPORTER_LIME = block(EndlessEndModBlocks.ENDERPORTER_LIME);
	public static final DeferredItem<Item> ENDERPORTER_GREEN = block(EndlessEndModBlocks.ENDERPORTER_GREEN);
	public static final DeferredItem<Item> ENDERPORTER_CYAN = block(EndlessEndModBlocks.ENDERPORTER_CYAN);
	public static final DeferredItem<Item> ENDERPORTER_LIGHT_BLUE = block(EndlessEndModBlocks.ENDERPORTER_LIGHT_BLUE);
	public static final DeferredItem<Item> ENDERPORTER_BLUE = block(EndlessEndModBlocks.ENDERPORTER_BLUE);
	public static final DeferredItem<Item> ENDERPORTER_PURPLE = block(EndlessEndModBlocks.ENDERPORTER_PURPLE);
	public static final DeferredItem<Item> ENDERPORTER_MAGENTA = block(EndlessEndModBlocks.ENDERPORTER_MAGENTA);
	public static final DeferredItem<Item> ENDERPORTER_PINK = block(EndlessEndModBlocks.ENDERPORTER_PINK);
	public static final DeferredItem<Item> ENDERPORTER_BROWN = block(EndlessEndModBlocks.ENDERPORTER_BROWN);
	public static final DeferredItem<Item> ENDERPORTER_LIGHT_GRAY = block(EndlessEndModBlocks.ENDERPORTER_LIGHT_GRAY);
	public static final DeferredItem<Item> ENDERPORTER_DARK_GRAY = block(EndlessEndModBlocks.ENDERPORTER_DARK_GRAY);
	public static final DeferredItem<Item> ENDERPORTER_BLACK = block(EndlessEndModBlocks.ENDERPORTER_BLACK);
	public static final DeferredItem<Item> SENDING_TRANSPONDER = REGISTRY.register("sending_transponder", SendingTransponderItem::new);
	public static final DeferredItem<Item> ENDORITE_TILES = block(EndlessEndModBlocks.ENDORITE_TILES);
	public static final DeferredItem<Item> PHASED_ENDORITE_TILES = block(EndlessEndModBlocks.PHASED_ENDORITE_TILES);
	public static final DeferredItem<Item> CANTICLE = block(EndlessEndModBlocks.CANTICLE);
	public static final DeferredItem<Item> ROTTING_END_STONE = block(EndlessEndModBlocks.ROTTING_END_STONE);
	public static final DeferredItem<Item> BLOOMING_CANTICLE = block(EndlessEndModBlocks.BLOOMING_CANTICLE);
	public static final DeferredItem<Item> LYDIAN_PETALS = block(EndlessEndModBlocks.LYDIAN_PETALS);
	public static final DeferredItem<Item> VERTABRAE = block(EndlessEndModBlocks.VERTABRAE);
	public static final DeferredItem<Item> BRITTLE_CARAPACE = REGISTRY.register("brittle_carapace", BrittleCarapaceItem::new);
	public static final DeferredItem<Item> INSECT_FLESH = REGISTRY.register("insect_flesh", InsectFleshItem::new);
	public static final DeferredItem<Item> GRAZER_SPAWN_EGG = REGISTRY.register("grazer_spawn_egg", () -> new DeferredSpawnEggItem(EndlessEndModEntities.GRAZER, -13434829, -6711040, new Item.Properties()));
	public static final DeferredItem<Item> ADAMANT = block(EndlessEndModBlocks.ADAMANT);
	public static final DeferredItem<Item> STAR_FRAGMENT = REGISTRY.register("star_fragment", StarFragmentItem::new);
	public static final DeferredItem<Item> BOTTLED_STARLIGHT = REGISTRY.register("bottled_starlight", BottledStarlightItem::new);
	public static final DeferredItem<Item> MOON_JELLY = REGISTRY.register("moon_jelly", MoonJellyItem::new);
	public static final DeferredItem<Item> TETHER = REGISTRY.register(EndlessEndModBlocks.TETHER.getId().getPath(), () -> new TetherDisplayItem(EndlessEndModBlocks.TETHER.get(), new Item.Properties()));
	public static final DeferredItem<Item> ESSENCE_BUCKET = REGISTRY.register("essence_bucket", EssenceItem::new);
	public static final DeferredItem<Item> TUNEROD_STEM = block(EndlessEndModBlocks.TUNEROD_STEM);
	public static final DeferredItem<Item> TUNE_BLOCK = block(EndlessEndModBlocks.TUNE_BLOCK);
	public static final DeferredItem<Item> MAGIC_WHISTLE = REGISTRY.register("magic_whistle", MagicWhistleItem::new);
	public static final DeferredItem<Item> DISC_FRAGMENT_ELEGY = REGISTRY.register("disc_fragment_elegy", DiscFragmentElegyItem::new);
	public static final DeferredItem<Item> YEARNING_EYE = REGISTRY.register("yearning_eye", YearningEyeItem::new);
	public static final DeferredItem<Item> EMPTY_EYE = REGISTRY.register("empty_eye", EmptyEyeItem::new);
	public static final DeferredItem<Item> HOLLOW_SPAWN_EGG = REGISTRY.register("hollow_spawn_egg", () -> new DeferredSpawnEggItem(EndlessEndModEntities.HOLLOW, -15525329, -15709365, new Item.Properties()));
	public static final DeferredItem<Item> WARDING_EYES = block(EndlessEndModBlocks.WARDING_EYES);
	public static final DeferredItem<Item> BURROWING_THORNS = block(EndlessEndModBlocks.BURROWING_THORNS);
	public static final DeferredItem<Item> SCULK_TEETH = block(EndlessEndModBlocks.SCULK_TEETH);
	public static final DeferredItem<Item> SPITEFUL_EYE = block(EndlessEndModBlocks.SPITEFUL_EYE);
	public static final DeferredItem<Item> SOUL_BULB = block(EndlessEndModBlocks.SOUL_BULB);
	public static final DeferredItem<Item> SOUL_BULB_FLOWER_POT = block(EndlessEndModBlocks.SOUL_BULB_FLOWER_POT);
	public static final DeferredItem<Item> SOUL_BULB_VASE = block(EndlessEndModBlocks.SOUL_BULB_VASE);
	public static final DeferredItem<Item> BLUE_ROSE = block(EndlessEndModBlocks.BLUE_ROSE);
	public static final DeferredItem<Item> BLUE_ROSE_FLOWER_POT = block(EndlessEndModBlocks.BLUE_ROSE_FLOWER_POT);
	public static final DeferredItem<Item> BLUE_ROSE_VASE = block(EndlessEndModBlocks.BLUE_ROSE_VASE);
	public static final DeferredItem<Item> SINGING_SAND = block(EndlessEndModBlocks.SINGING_SAND);
	public static final DeferredItem<Item> SPIRALING_SAND = block(EndlessEndModBlocks.SPIRALING_SAND);
	public static final DeferredItem<Item> AMNESOCLAST = block(EndlessEndModBlocks.AMNESOCLAST);
	public static final DeferredItem<Item> ICONOCLAST = block(EndlessEndModBlocks.ICONOCLAST);
	public static final DeferredItem<Item> DORMANT_ICONOCLAST = block(EndlessEndModBlocks.DORMANT_ICONOCLAST);
	public static final DeferredItem<Item> END_AMETHYST = block(EndlessEndModBlocks.END_AMETHYST);
	public static final DeferredItem<Item> REFUSE = block(EndlessEndModBlocks.REFUSE);
	public static final DeferredItem<Item> COBBLED_ENDSTONE = block(EndlessEndModBlocks.COBBLED_ENDSTONE);
	public static final DeferredItem<Item> END_DIAMONDS = block(EndlessEndModBlocks.END_DIAMONDS);
	public static final DeferredItem<Item> INTRO = REGISTRY.register("intro", IntroItem::new);
	public static final DeferredItem<Item> ELEGY = REGISTRY.register("elegy", ElegyItem::new);
	public static final DeferredItem<Item> ELEVEN_REPAIRED = REGISTRY.register("eleven_repaired", ElevenRepairedItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void clientLoad(FMLClientSetupEvent event) {
			event.enqueueWork(() -> {
				ItemProperties.register(YEARNING_EYE.get(), ResourceLocation.parse("endless_end:yearning_eye_direction"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) EyeballProviderProcedure.execute(entity));
				ItemProperties.register(YEARNING_EYE.get(), ResourceLocation.parse("endless_end:yearning_eye_proximity"),
						(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) EyeProximityProviderProcedure.execute(entity, itemStackToRender));
			});
		}
	}
}
