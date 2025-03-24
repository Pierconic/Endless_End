
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.endless_end.block.WardingEyesBlock;
import net.mcreator.endless_end.block.VioletSepalWoodBlock;
import net.mcreator.endless_end.block.VioletSepalStairsBlock;
import net.mcreator.endless_end.block.VioletSepalSlabBlock;
import net.mcreator.endless_end.block.VioletSepalPressurePlateBlock;
import net.mcreator.endless_end.block.VioletSepalPlanksBlock;
import net.mcreator.endless_end.block.VioletSepalLogBlock;
import net.mcreator.endless_end.block.VioletSepalLeavesBlock;
import net.mcreator.endless_end.block.VioletSepalFenceGateBlock;
import net.mcreator.endless_end.block.VioletSepalFenceBlock;
import net.mcreator.endless_end.block.VioletSepalButtonBlock;
import net.mcreator.endless_end.block.VertabraeBlock;
import net.mcreator.endless_end.block.TunerodStemBlock;
import net.mcreator.endless_end.block.TuneBlockBlock;
import net.mcreator.endless_end.block.TransceiverSendingOnBlock;
import net.mcreator.endless_end.block.TransceiverSendingOffBlock;
import net.mcreator.endless_end.block.TransceiverRecievingOnBlock;
import net.mcreator.endless_end.block.TransceiverBlock;
import net.mcreator.endless_end.block.TetherBlock;
import net.mcreator.endless_end.block.StrippedVioletSepalWoodBlock;
import net.mcreator.endless_end.block.StrippedVioletSepalLogBlock;
import net.mcreator.endless_end.block.SpitefulEyeBlock;
import net.mcreator.endless_end.block.SpiralingSandBlock;
import net.mcreator.endless_end.block.SoulBulbVaseBlock;
import net.mcreator.endless_end.block.SoulBulbFlowerPotBlock;
import net.mcreator.endless_end.block.SoulBulbBlock;
import net.mcreator.endless_end.block.SingingSandBlock;
import net.mcreator.endless_end.block.SensingEndoriteCoreBlock;
import net.mcreator.endless_end.block.SculkTeethBlock;
import net.mcreator.endless_end.block.RottingEndStoneBlock;
import net.mcreator.endless_end.block.RefuseBlock;
import net.mcreator.endless_end.block.PhasedEndoriteTilesBlock;
import net.mcreator.endless_end.block.PhasedEndoriteMeshBlock;
import net.mcreator.endless_end.block.MoonJellyBlockBlock;
import net.mcreator.endless_end.block.MoonGunkBlock;
import net.mcreator.endless_end.block.MolderingPurpurBlock;
import net.mcreator.endless_end.block.LydianPetalsBlock;
import net.mcreator.endless_end.block.IconoclastBlock;
import net.mcreator.endless_end.block.EssenceBlock;
import net.mcreator.endless_end.block.EndoriteTilesBlock;
import net.mcreator.endless_end.block.EndoriteOreBlock;
import net.mcreator.endless_end.block.EndoriteMeshBlock;
import net.mcreator.endless_end.block.EndoriteCoreBlock;
import net.mcreator.endless_end.block.EndoriteBlockBlock;
import net.mcreator.endless_end.block.EnderporterYellowBlock;
import net.mcreator.endless_end.block.EnderporterWhiteBlock;
import net.mcreator.endless_end.block.EnderporterRedBlock;
import net.mcreator.endless_end.block.EnderporterPurpleBlock;
import net.mcreator.endless_end.block.EnderporterPinkBlock;
import net.mcreator.endless_end.block.EnderporterOrangeBlock;
import net.mcreator.endless_end.block.EnderporterMagentaBlock;
import net.mcreator.endless_end.block.EnderporterLimeBlock;
import net.mcreator.endless_end.block.EnderporterLightGrayBlock;
import net.mcreator.endless_end.block.EnderporterLightBlueBlock;
import net.mcreator.endless_end.block.EnderporterGreenBlock;
import net.mcreator.endless_end.block.EnderporterDarkGrayBlock;
import net.mcreator.endless_end.block.EnderporterCyanBlock;
import net.mcreator.endless_end.block.EnderporterBrownBlock;
import net.mcreator.endless_end.block.EnderporterBlueBlock;
import net.mcreator.endless_end.block.EnderporterBlackBlock;
import net.mcreator.endless_end.block.EndIronBlock;
import net.mcreator.endless_end.block.EndDiamondsBlock;
import net.mcreator.endless_end.block.EndAmethystBlock;
import net.mcreator.endless_end.block.DormantIconoclastBlock;
import net.mcreator.endless_end.block.DissipatingEndoriteBlock;
import net.mcreator.endless_end.block.CrackedEndStoneBricksBlock;
import net.mcreator.endless_end.block.CobbledEndstoneBlock;
import net.mcreator.endless_end.block.ChorusSproutsBlock;
import net.mcreator.endless_end.block.ChiseledEndstoneBlock;
import net.mcreator.endless_end.block.CanticleBlock;
import net.mcreator.endless_end.block.BurrowingThornsBlock;
import net.mcreator.endless_end.block.BlueRoseVaseBlock;
import net.mcreator.endless_end.block.BlueRoseFlowerPotBlock;
import net.mcreator.endless_end.block.BlueRoseBlock;
import net.mcreator.endless_end.block.BloomingCanticleBlock;
import net.mcreator.endless_end.block.AmnesoclastBlock;
import net.mcreator.endless_end.block.AdamantBlock;
import net.mcreator.endless_end.EndlessEndMod;

public class EndlessEndModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(EndlessEndMod.MODID);
	public static final DeferredBlock<Block> CHISELED_ENDSTONE = REGISTRY.register("chiseled_endstone", ChiseledEndstoneBlock::new);
	public static final DeferredBlock<Block> CRACKED_END_STONE_BRICKS = REGISTRY.register("cracked_end_stone_bricks", CrackedEndStoneBricksBlock::new);
	public static final DeferredBlock<Block> ENDORITE_ORE = REGISTRY.register("endorite_ore", EndoriteOreBlock::new);
	public static final DeferredBlock<Block> END_IRON = REGISTRY.register("end_iron", EndIronBlock::new);
	public static final DeferredBlock<Block> ENDORITE_BLOCK = REGISTRY.register("endorite_block", EndoriteBlockBlock::new);
	public static final DeferredBlock<Block> DISSIPATING_ENDORITE = REGISTRY.register("dissipating_endorite", DissipatingEndoriteBlock::new);
	public static final DeferredBlock<Block> ENDORITE_MESH = REGISTRY.register("endorite_mesh", EndoriteMeshBlock::new);
	public static final DeferredBlock<Block> PHASED_ENDORITE_MESH = REGISTRY.register("phased_endorite_mesh", PhasedEndoriteMeshBlock::new);
	public static final DeferredBlock<Block> ENDORITE_CORE = REGISTRY.register("endorite_core", EndoriteCoreBlock::new);
	public static final DeferredBlock<Block> SENSING_ENDORITE_CORE = REGISTRY.register("sensing_endorite_core", SensingEndoriteCoreBlock::new);
	public static final DeferredBlock<Block> TRANSCEIVER = REGISTRY.register("transceiver", TransceiverBlock::new);
	public static final DeferredBlock<Block> TRANSCEIVER_SENDING_OFF = REGISTRY.register("transceiver_sending_off", TransceiverSendingOffBlock::new);
	public static final DeferredBlock<Block> TRANSCEIVER_SENDING_ON = REGISTRY.register("transceiver_sending_on", TransceiverSendingOnBlock::new);
	public static final DeferredBlock<Block> TRANSCEIVER_RECIEVING_ON = REGISTRY.register("transceiver_recieving_on", TransceiverRecievingOnBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_WHITE = REGISTRY.register("enderporter_white", EnderporterWhiteBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_RED = REGISTRY.register("enderporter_red", EnderporterRedBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_ORANGE = REGISTRY.register("enderporter_orange", EnderporterOrangeBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_YELLOW = REGISTRY.register("enderporter_yellow", EnderporterYellowBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_LIME = REGISTRY.register("enderporter_lime", EnderporterLimeBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_GREEN = REGISTRY.register("enderporter_green", EnderporterGreenBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_CYAN = REGISTRY.register("enderporter_cyan", EnderporterCyanBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_LIGHT_BLUE = REGISTRY.register("enderporter_light_blue", EnderporterLightBlueBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_BLUE = REGISTRY.register("enderporter_blue", EnderporterBlueBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_PURPLE = REGISTRY.register("enderporter_purple", EnderporterPurpleBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_MAGENTA = REGISTRY.register("enderporter_magenta", EnderporterMagentaBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_PINK = REGISTRY.register("enderporter_pink", EnderporterPinkBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_BROWN = REGISTRY.register("enderporter_brown", EnderporterBrownBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_LIGHT_GRAY = REGISTRY.register("enderporter_light_gray", EnderporterLightGrayBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_DARK_GRAY = REGISTRY.register("enderporter_dark_gray", EnderporterDarkGrayBlock::new);
	public static final DeferredBlock<Block> ENDERPORTER_BLACK = REGISTRY.register("enderporter_black", EnderporterBlackBlock::new);
	public static final DeferredBlock<Block> ENDORITE_TILES = REGISTRY.register("endorite_tiles", EndoriteTilesBlock::new);
	public static final DeferredBlock<Block> PHASED_ENDORITE_TILES = REGISTRY.register("phased_endorite_tiles", PhasedEndoriteTilesBlock::new);
	public static final DeferredBlock<Block> CANTICLE = REGISTRY.register("canticle", CanticleBlock::new);
	public static final DeferredBlock<Block> ROTTING_END_STONE = REGISTRY.register("rotting_end_stone", RottingEndStoneBlock::new);
	public static final DeferredBlock<Block> BLOOMING_CANTICLE = REGISTRY.register("blooming_canticle", BloomingCanticleBlock::new);
	public static final DeferredBlock<Block> LYDIAN_PETALS = REGISTRY.register("lydian_petals", LydianPetalsBlock::new);
	public static final DeferredBlock<Block> VERTABRAE = REGISTRY.register("vertabrae", VertabraeBlock::new);
	public static final DeferredBlock<Block> ADAMANT = REGISTRY.register("adamant", AdamantBlock::new);
	public static final DeferredBlock<Block> TETHER = REGISTRY.register("tether", TetherBlock::new);
	public static final DeferredBlock<Block> ESSENCE = REGISTRY.register("essence", EssenceBlock::new);
	public static final DeferredBlock<Block> TUNEROD_STEM = REGISTRY.register("tunerod_stem", TunerodStemBlock::new);
	public static final DeferredBlock<Block> TUNE_BLOCK = REGISTRY.register("tune_block", TuneBlockBlock::new);
	public static final DeferredBlock<Block> WARDING_EYES = REGISTRY.register("warding_eyes", WardingEyesBlock::new);
	public static final DeferredBlock<Block> BURROWING_THORNS = REGISTRY.register("burrowing_thorns", BurrowingThornsBlock::new);
	public static final DeferredBlock<Block> SCULK_TEETH = REGISTRY.register("sculk_teeth", SculkTeethBlock::new);
	public static final DeferredBlock<Block> SPITEFUL_EYE = REGISTRY.register("spiteful_eye", SpitefulEyeBlock::new);
	public static final DeferredBlock<Block> SOUL_BULB = REGISTRY.register("soul_bulb", SoulBulbBlock::new);
	public static final DeferredBlock<Block> SOUL_BULB_FLOWER_POT = REGISTRY.register("soul_bulb_flower_pot", SoulBulbFlowerPotBlock::new);
	public static final DeferredBlock<Block> SOUL_BULB_VASE = REGISTRY.register("soul_bulb_vase", SoulBulbVaseBlock::new);
	public static final DeferredBlock<Block> BLUE_ROSE = REGISTRY.register("blue_rose", BlueRoseBlock::new);
	public static final DeferredBlock<Block> BLUE_ROSE_FLOWER_POT = REGISTRY.register("blue_rose_flower_pot", BlueRoseFlowerPotBlock::new);
	public static final DeferredBlock<Block> BLUE_ROSE_VASE = REGISTRY.register("blue_rose_vase", BlueRoseVaseBlock::new);
	public static final DeferredBlock<Block> SINGING_SAND = REGISTRY.register("singing_sand", SingingSandBlock::new);
	public static final DeferredBlock<Block> SPIRALING_SAND = REGISTRY.register("spiraling_sand", SpiralingSandBlock::new);
	public static final DeferredBlock<Block> AMNESOCLAST = REGISTRY.register("amnesoclast", AmnesoclastBlock::new);
	public static final DeferredBlock<Block> ICONOCLAST = REGISTRY.register("iconoclast", IconoclastBlock::new);
	public static final DeferredBlock<Block> DORMANT_ICONOCLAST = REGISTRY.register("dormant_iconoclast", DormantIconoclastBlock::new);
	public static final DeferredBlock<Block> END_AMETHYST = REGISTRY.register("end_amethyst", EndAmethystBlock::new);
	public static final DeferredBlock<Block> REFUSE = REGISTRY.register("refuse", RefuseBlock::new);
	public static final DeferredBlock<Block> COBBLED_ENDSTONE = REGISTRY.register("cobbled_endstone", CobbledEndstoneBlock::new);
	public static final DeferredBlock<Block> END_DIAMONDS = REGISTRY.register("end_diamonds", EndDiamondsBlock::new);
	public static final DeferredBlock<Block> MOON_JELLY_BLOCK = REGISTRY.register("moon_jelly_block", MoonJellyBlockBlock::new);
	public static final DeferredBlock<Block> MOON_GUNK = REGISTRY.register("moon_gunk", MoonGunkBlock::new);
	public static final DeferredBlock<Block> VIOLET_SEPAL_WOOD = REGISTRY.register("violet_sepal_wood", VioletSepalWoodBlock::new);
	public static final DeferredBlock<Block> VIOLET_SEPAL_LOG = REGISTRY.register("violet_sepal_log", VioletSepalLogBlock::new);
	public static final DeferredBlock<Block> VIOLET_SEPAL_PLANKS = REGISTRY.register("violet_sepal_planks", VioletSepalPlanksBlock::new);
	public static final DeferredBlock<Block> VIOLET_SEPAL_LEAVES = REGISTRY.register("violet_sepal_leaves", VioletSepalLeavesBlock::new);
	public static final DeferredBlock<Block> VIOLET_SEPAL_STAIRS = REGISTRY.register("violet_sepal_stairs", VioletSepalStairsBlock::new);
	public static final DeferredBlock<Block> VIOLET_SEPAL_SLAB = REGISTRY.register("violet_sepal_slab", VioletSepalSlabBlock::new);
	public static final DeferredBlock<Block> VIOLET_SEPAL_FENCE = REGISTRY.register("violet_sepal_fence", VioletSepalFenceBlock::new);
	public static final DeferredBlock<Block> VIOLET_SEPAL_FENCE_GATE = REGISTRY.register("violet_sepal_fence_gate", VioletSepalFenceGateBlock::new);
	public static final DeferredBlock<Block> VIOLET_SEPAL_PRESSURE_PLATE = REGISTRY.register("violet_sepal_pressure_plate", VioletSepalPressurePlateBlock::new);
	public static final DeferredBlock<Block> VIOLET_SEPAL_BUTTON = REGISTRY.register("violet_sepal_button", VioletSepalButtonBlock::new);
	public static final DeferredBlock<Block> STRIPPED_VIOLET_SEPAL_LOG = REGISTRY.register("stripped_violet_sepal_log", StrippedVioletSepalLogBlock::new);
	public static final DeferredBlock<Block> STRIPPED_VIOLET_SEPAL_WOOD = REGISTRY.register("stripped_violet_sepal_wood", StrippedVioletSepalWoodBlock::new);
	public static final DeferredBlock<Block> CHORUS_SPROUTS = REGISTRY.register("chorus_sprouts", ChorusSproutsBlock::new);
	public static final DeferredBlock<Block> MOLDERING_PURPUR = REGISTRY.register("moldering_purpur", MolderingPurpurBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			SoulBulbFlowerPotBlock.blockColorLoad(event);
			BlueRoseFlowerPotBlock.blockColorLoad(event);
		}
	}
}
