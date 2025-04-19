package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterPurpleBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterPurpleTileEntity;

public class EnderporterPurpleTileRenderer extends GeoBlockRenderer<EnderporterPurpleTileEntity> {
	public EnderporterPurpleTileRenderer() {
		super(new EnderporterPurpleBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterPurpleTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
