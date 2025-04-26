package net.mcreator.endless_end.block.listener;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.entity.BlockEntityType;

import net.mcreator.endless_end.init.EndlessEndModBlockEntities;
import net.mcreator.endless_end.block.renderer.TetherTileRenderer;
import net.mcreator.endless_end.block.renderer.PuffBlossomTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterYellowTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterWhiteTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterRedTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterPurpleTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterPinkTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterOrangeTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterMagentaTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterLimeTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterLightGrayTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterLightBlueTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterGreenTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterDarkGrayTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterCyanTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterBrownTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterBlueTileRenderer;
import net.mcreator.endless_end.block.renderer.EnderporterBlackTileRenderer;
import net.mcreator.endless_end.block.entity.TetherTileEntity;
import net.mcreator.endless_end.block.entity.PuffBlossomTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterYellowTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterWhiteTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterRedTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterPurpleTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterPinkTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterOrangeTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterMagentaTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterLimeTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterLightGrayTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterLightBlueTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterGreenTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterDarkGrayTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterCyanTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterBrownTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterBlueTileEntity;
import net.mcreator.endless_end.block.entity.EnderporterBlackTileEntity;
import net.mcreator.endless_end.EndlessEndMod;

@EventBusSubscriber(modid = EndlessEndMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer((BlockEntityType<TetherTileEntity>) EndlessEndModBlockEntities.TETHER.get(), context -> new TetherTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterWhiteTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_WHITE.get(), context -> new EnderporterWhiteTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterRedTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_RED.get(), context -> new EnderporterRedTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterOrangeTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_ORANGE.get(), context -> new EnderporterOrangeTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterYellowTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_YELLOW.get(), context -> new EnderporterYellowTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterLimeTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_LIME.get(), context -> new EnderporterLimeTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterGreenTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_GREEN.get(), context -> new EnderporterGreenTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterCyanTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_CYAN.get(), context -> new EnderporterCyanTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterLightBlueTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_LIGHT_BLUE.get(), context -> new EnderporterLightBlueTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterBlueTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_BLUE.get(), context -> new EnderporterBlueTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterPurpleTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_PURPLE.get(), context -> new EnderporterPurpleTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterMagentaTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_MAGENTA.get(), context -> new EnderporterMagentaTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterPinkTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_PINK.get(), context -> new EnderporterPinkTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterBrownTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_BROWN.get(), context -> new EnderporterBrownTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterLightGrayTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_LIGHT_GRAY.get(), context -> new EnderporterLightGrayTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterDarkGrayTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_DARK_GRAY.get(), context -> new EnderporterDarkGrayTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<EnderporterBlackTileEntity>) EndlessEndModBlockEntities.ENDERPORTER_BLACK.get(), context -> new EnderporterBlackTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<PuffBlossomTileEntity>) EndlessEndModBlockEntities.PUFF_BLOSSOM.get(), context -> new PuffBlossomTileRenderer());
	}
}
