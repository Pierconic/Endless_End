package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterMagentaBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterMagentaTileEntity;

public class EnderporterMagentaTileRenderer extends GeoBlockRenderer<EnderporterMagentaTileEntity> {
	public EnderporterMagentaTileRenderer() {
		super(new EnderporterMagentaBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterMagentaTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
