package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterLimeDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterLimeDisplayItem;

public class EnderporterLimeDisplayItemRenderer extends GeoItemRenderer<EnderporterLimeDisplayItem> {
	public EnderporterLimeDisplayItemRenderer() {
		super(new EnderporterLimeDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterLimeDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
