package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterLightBlueBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterLightBlueTileEntity;

public class EnderporterLightBlueTileRenderer extends GeoBlockRenderer<EnderporterLightBlueTileEntity> {
	public EnderporterLightBlueTileRenderer() {
		super(new EnderporterLightBlueBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterLightBlueTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
