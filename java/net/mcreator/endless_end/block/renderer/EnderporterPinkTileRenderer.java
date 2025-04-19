package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterPinkBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterPinkTileEntity;

public class EnderporterPinkTileRenderer extends GeoBlockRenderer<EnderporterPinkTileEntity> {
	public EnderporterPinkTileRenderer() {
		super(new EnderporterPinkBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterPinkTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
