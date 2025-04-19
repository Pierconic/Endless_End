package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterWhiteBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterWhiteTileEntity;

public class EnderporterWhiteTileRenderer extends GeoBlockRenderer<EnderporterWhiteTileEntity> {
	public EnderporterWhiteTileRenderer() {
		super(new EnderporterWhiteBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterWhiteTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
