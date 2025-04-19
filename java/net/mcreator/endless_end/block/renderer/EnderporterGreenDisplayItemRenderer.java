package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterGreenDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterGreenDisplayItem;

public class EnderporterGreenDisplayItemRenderer extends GeoItemRenderer<EnderporterGreenDisplayItem> {
	public EnderporterGreenDisplayItemRenderer() {
		super(new EnderporterGreenDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterGreenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
