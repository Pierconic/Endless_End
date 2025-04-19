package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.EnderporterYellowBlockModel;
import net.mcreator.endless_end.block.entity.EnderporterYellowTileEntity;

public class EnderporterYellowTileRenderer extends GeoBlockRenderer<EnderporterYellowTileEntity> {
	public EnderporterYellowTileRenderer() {
		super(new EnderporterYellowBlockModel());
	}

	@Override
	public RenderType getRenderType(EnderporterYellowTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
