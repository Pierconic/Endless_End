package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterBrownBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterBrownTileEntity;

public class EnderporterBrownTileRenderer extends GeoBlockRenderer<EnderporterBrownTileEntity> {
	public EnderporterBrownTileRenderer() {
		super(new EnderporterBrownBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterBrownTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
