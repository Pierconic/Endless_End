package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.PuffBlossomDisplayItem;

public class PuffBlossomDisplayModel extends GeoModel<PuffBlossomDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(PuffBlossomDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/puff_blossom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PuffBlossomDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/puff_blossom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PuffBlossomDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/puff_blossom.png");
	}
}
