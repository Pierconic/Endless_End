package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterCyanDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterCyanDisplayItem;

public class EnderporterCyanDisplayItemRenderer extends GeoItemRenderer<EnderporterCyanDisplayItem> {
	public EnderporterCyanDisplayItemRenderer() {
		super(new EnderporterCyanDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterCyanDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
