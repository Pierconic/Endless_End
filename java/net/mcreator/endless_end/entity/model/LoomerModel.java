package net.mcreator.endless_end.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.entity.LoomerEntity;

public class LoomerModel extends GeoModel<LoomerEntity> {
	@Override
	public ResourceLocation getAnimationResource(LoomerEntity entity) {
		return ResourceLocation.parse("endless_end:animations/loomer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LoomerEntity entity) {
		return ResourceLocation.parse("endless_end:geo/loomer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LoomerEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/" + entity.getTexture() + ".png");
	}

}
