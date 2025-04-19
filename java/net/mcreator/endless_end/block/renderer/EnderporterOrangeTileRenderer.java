package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterOrangeBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterOrangeTileEntity;

public class EnderporterOrangeTileRenderer extends GeoBlockRenderer<EnderporterOrangeTileEntity> {
	public EnderporterOrangeTileRenderer() {
		super(new EnderporterOrangeBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterOrangeTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
