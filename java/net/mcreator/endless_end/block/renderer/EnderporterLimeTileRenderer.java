package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterLimeBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterLimeTileEntity;

public class EnderporterLimeTileRenderer extends GeoBlockRenderer<EnderporterLimeTileEntity> {
	public EnderporterLimeTileRenderer() {
		super(new EnderporterLimeBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterLimeTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
