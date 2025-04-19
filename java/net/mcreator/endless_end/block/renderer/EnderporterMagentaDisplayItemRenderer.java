package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterMagentaDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterMagentaDisplayItem;

public class EnderporterMagentaDisplayItemRenderer extends GeoItemRenderer<EnderporterMagentaDisplayItem> {
	public EnderporterMagentaDisplayItemRenderer() {
		super(new EnderporterMagentaDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterMagentaDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
