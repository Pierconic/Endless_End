package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterRedBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterRedTileEntity;

public class EnderporterRedTileRenderer extends GeoBlockRenderer<EnderporterRedTileEntity> {
	public EnderporterRedTileRenderer() {
		super(new EnderporterRedBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterRedTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
