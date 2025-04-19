package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterYellowDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterYellowDisplayItem;

public class EnderporterYellowDisplayItemRenderer extends GeoItemRenderer<EnderporterYellowDisplayItem> {
	public EnderporterYellowDisplayItemRenderer() {
		super(new EnderporterYellowDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterYellowDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
