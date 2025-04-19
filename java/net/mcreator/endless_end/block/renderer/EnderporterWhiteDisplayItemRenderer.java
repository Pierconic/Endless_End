package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterWhiteDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterWhiteDisplayItem;

public class EnderporterWhiteDisplayItemRenderer extends GeoItemRenderer<EnderporterWhiteDisplayItem> {
	public EnderporterWhiteDisplayItemRenderer() {
		super(new EnderporterWhiteDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterWhiteDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
