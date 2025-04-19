package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterDarkGrayDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterDarkGrayDisplayItem;

public class EnderporterDarkGrayDisplayItemRenderer extends GeoItemRenderer<EnderporterDarkGrayDisplayItem> {
	public EnderporterDarkGrayDisplayItemRenderer() {
		super(new EnderporterDarkGrayDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterDarkGrayDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
