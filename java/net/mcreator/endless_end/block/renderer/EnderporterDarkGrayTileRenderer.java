package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterDarkGrayBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterDarkGrayTileEntity;

public class EnderporterDarkGrayTileRenderer extends GeoBlockRenderer<EnderporterDarkGrayTileEntity> {
	public EnderporterDarkGrayTileRenderer() {
		super(new EnderporterDarkGrayBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterDarkGrayTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
