package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.TetherDisplayItem;

public class TetherDisplayModel extends GeoModel<TetherDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(TetherDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/tether.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TetherDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/tether.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TetherDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/tether.png");
	}
}
