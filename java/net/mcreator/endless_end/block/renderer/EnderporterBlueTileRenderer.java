package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterBlueBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterBlueTileEntity;

public class EnderporterBlueTileRenderer extends GeoBlockRenderer<EnderporterBlueTileEntity> {
	public EnderporterBlueTileRenderer() {
		super(new EnderporterBlueBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterBlueTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
