package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterRedDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterRedDisplayItem;

public class EnderporterRedDisplayItemRenderer extends GeoItemRenderer<EnderporterRedDisplayItem> {
	public EnderporterRedDisplayItemRenderer() {
		super(new EnderporterRedDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterRedDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
