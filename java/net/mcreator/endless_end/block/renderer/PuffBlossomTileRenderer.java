package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.PuffBlossomBlockModel;
import net.mcreator.endless_end.block.entity.PuffBlossomTileEntity;

public class PuffBlossomTileRenderer extends GeoBlockRenderer<PuffBlossomTileEntity> {
	public PuffBlossomTileRenderer() {
		super(new PuffBlossomBlockModel());
	}

	@Override
	public RenderType getRenderType(PuffBlossomTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
