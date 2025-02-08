package net.mcreator.endless_end.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.block.model.TetherDisplayModel;
import net.mcreator.endless_end.block.display.TetherDisplayItem;

public class TetherDisplayItemRenderer extends GeoItemRenderer<TetherDisplayItem> {
	public TetherDisplayItemRenderer() {
		super(new TetherDisplayModel());
	}

	@Override
	public RenderType getRenderType(TetherDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
