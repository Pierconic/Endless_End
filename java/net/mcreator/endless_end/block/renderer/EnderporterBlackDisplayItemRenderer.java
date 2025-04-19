package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterBlackDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterBlackDisplayItem;

public class EnderporterBlackDisplayItemRenderer extends GeoItemRenderer<EnderporterBlackDisplayItem> {
	public EnderporterBlackDisplayItemRenderer() {
		super(new EnderporterBlackDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterBlackDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
