package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterGreenBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterGreenTileEntity;

public class EnderporterGreenTileRenderer extends GeoBlockRenderer<EnderporterGreenTileEntity> {
	public EnderporterGreenTileRenderer() {
		super(new EnderporterGreenBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterGreenTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
