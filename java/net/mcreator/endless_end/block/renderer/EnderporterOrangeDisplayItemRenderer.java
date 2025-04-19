package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterOrangeDisplayModel;
import net.mcreator.endless_end.block.display.EnderporterOrangeDisplayItem;

public class EnderporterOrangeDisplayItemRenderer extends GeoItemRenderer<EnderporterOrangeDisplayItem> {
	public EnderporterOrangeDisplayItemRenderer() {
		super(new EnderporterOrangeDisplayModel());
	}

	@Override
	public RenderType getRenderType(EnderporterOrangeDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
