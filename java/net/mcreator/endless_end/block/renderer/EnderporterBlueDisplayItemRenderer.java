package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterBlueDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterBlueDisplayItem;

public class EnderporterBlueDisplayItemRenderer extends GeoItemRenderer<EnderporterBlueDisplayItem> {
	public EnderporterBlueDisplayItemRenderer() {
		super(new EnderporterBlueDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterBlueDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
