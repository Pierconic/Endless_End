package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterBrownDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterBrownDisplayItem;

public class EnderporterBrownDisplayItemRenderer extends GeoItemRenderer<EnderporterBrownDisplayItem> {
	public EnderporterBrownDisplayItemRenderer() {
		super(new EnderporterBrownDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterBrownDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
