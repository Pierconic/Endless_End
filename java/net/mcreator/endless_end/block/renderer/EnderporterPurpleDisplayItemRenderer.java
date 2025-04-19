package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterPurpleDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterPurpleDisplayItem;

public class EnderporterPurpleDisplayItemRenderer extends GeoItemRenderer<EnderporterPurpleDisplayItem> {
	public EnderporterPurpleDisplayItemRenderer() {
		super(new EnderporterPurpleDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterPurpleDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
