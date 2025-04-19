package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterLightGrayBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterLightGrayTileEntity;

public class EnderporterLightGrayTileRenderer extends GeoBlockRenderer<EnderporterLightGrayTileEntity> {
	public EnderporterLightGrayTileRenderer() {
		super(new EnderporterLightGrayBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterLightGrayTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
