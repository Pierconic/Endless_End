package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterLightGrayDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterLightGrayDisplayItem;

public class EnderporterLightGrayDisplayItemRenderer extends GeoItemRenderer<EnderporterLightGrayDisplayItem> {
	public EnderporterLightGrayDisplayItemRenderer() {
		super(new EnderporterLightGrayDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterLightGrayDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
