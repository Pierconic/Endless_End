package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.TetherBlockModel;
import net.mcreator.endless_end.block.entity.TetherTileEntity;

public class TetherTileRenderer extends GeoBlockRenderer<TetherTileEntity> {
	public TetherTileRenderer() {
		super(new TetherBlockModel());
	}

	@Override
	public RenderType getRenderType(TetherTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
