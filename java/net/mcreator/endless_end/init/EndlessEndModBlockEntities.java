
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.endless_end.block.entity.WardingEyesBlockEntity;
import net.mcreator.endless_end.block.entity.TunerodStemBlockEntity;
import net.mcreator.endless_end.block.entity.TuneBlockBlockEntity;
import net.mcreator.endless_end.block.entity.TransceiverSendingOnBlockEntity;
import net.mcreator.endless_end.block.entity.TransceiverSendingOffBlockEntity;
import net.mcreator.endless_end.block.entity.TransceiverRecievingOnBlockEntity;
import net.mcreator.endless_end.block.entity.TransceiverBlockEntity;
import net.mcreator.endless_end.block.entity.TetherTileEntity;
import net.mcreator.endless_end.block.entity.SpitefulEyeBlockEntity;
import net.mcreator.endless_end.block.entity.SpiralingSandBlockEntity;
import net.mcreator.endless_end.block.entity.SingingSandBlockEntity;
import net.mcreator.endless_end.block.entity.SculkTeethBlockEntity;
import net.mcreator.endless_end.block.entity.PhasedEndoriteTilesBlockEntity;
import net.mcreator.endless_end.block.entity.IconoclastBlockEntity;
import net.mcreator.endless_end.block.entity.FlavorblockBlockEntity;
import net.mcreator.endless_end.block.entity.BurrowingThornsBlockEntity;
import net.mcreator.endless_end.EndlessEndMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class EndlessEndModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, EndlessEndMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TRANSCEIVER = register("transceiver", EndlessEndModBlocks.TRANSCEIVER, TransceiverBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TRANSCEIVER_SENDING_OFF = register("transceiver_sending_off", EndlessEndModBlocks.TRANSCEIVER_SENDING_OFF, TransceiverSendingOffBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TRANSCEIVER_SENDING_ON = register("transceiver_sending_on", EndlessEndModBlocks.TRANSCEIVER_SENDING_ON, TransceiverSendingOnBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TRANSCEIVER_RECIEVING_ON = register("transceiver_recieving_on", EndlessEndModBlocks.TRANSCEIVER_RECIEVING_ON, TransceiverRecievingOnBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PHASED_ENDORITE_TILES = register("phased_endorite_tiles", EndlessEndModBlocks.PHASED_ENDORITE_TILES, PhasedEndoriteTilesBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TETHER = register("tether", EndlessEndModBlocks.TETHER, TetherTileEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TUNEROD_STEM = register("tunerod_stem", EndlessEndModBlocks.TUNEROD_STEM, TunerodStemBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TUNE_BLOCK = register("tune_block", EndlessEndModBlocks.TUNE_BLOCK, TuneBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FLAVORBLOCK = register("flavorblock", EndlessEndModBlocks.FLAVORBLOCK, FlavorblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> WARDING_EYES = register("warding_eyes", EndlessEndModBlocks.WARDING_EYES, WardingEyesBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BURROWING_THORNS = register("burrowing_thorns", EndlessEndModBlocks.BURROWING_THORNS, BurrowingThornsBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SCULK_TEETH = register("sculk_teeth", EndlessEndModBlocks.SCULK_TEETH, SculkTeethBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SPITEFUL_EYE = register("spiteful_eye", EndlessEndModBlocks.SPITEFUL_EYE, SpitefulEyeBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SINGING_SAND = register("singing_sand", EndlessEndModBlocks.SINGING_SAND, SingingSandBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SPIRALING_SAND = register("spiraling_sand", EndlessEndModBlocks.SPIRALING_SAND, SpiralingSandBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ICONOCLAST = register("iconoclast", EndlessEndModBlocks.ICONOCLAST, IconoclastBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TRANSCEIVER.get(), (blockEntity, side) -> ((TransceiverBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TRANSCEIVER_SENDING_OFF.get(), (blockEntity, side) -> ((TransceiverSendingOffBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TRANSCEIVER_SENDING_ON.get(), (blockEntity, side) -> ((TransceiverSendingOnBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TRANSCEIVER_RECIEVING_ON.get(), (blockEntity, side) -> ((TransceiverRecievingOnBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PHASED_ENDORITE_TILES.get(), (blockEntity, side) -> ((PhasedEndoriteTilesBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TUNEROD_STEM.get(), (blockEntity, side) -> ((TunerodStemBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TUNE_BLOCK.get(), (blockEntity, side) -> ((TuneBlockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLAVORBLOCK.get(), (blockEntity, side) -> ((FlavorblockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WARDING_EYES.get(), (blockEntity, side) -> ((WardingEyesBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BURROWING_THORNS.get(), (blockEntity, side) -> ((BurrowingThornsBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SCULK_TEETH.get(), (blockEntity, side) -> ((SculkTeethBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SPITEFUL_EYE.get(), (blockEntity, side) -> ((SpitefulEyeBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SINGING_SAND.get(), (blockEntity, side) -> ((SingingSandBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SPIRALING_SAND.get(), (blockEntity, side) -> ((SpiralingSandBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ICONOCLAST.get(), (blockEntity, side) -> ((IconoclastBlockEntity) blockEntity).getItemHandler());
	}
}
