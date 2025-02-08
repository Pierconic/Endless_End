package net.mcreator.endless_end.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.entity.GrazerEntity;

public class GrazerModel extends GeoModel<GrazerEntity> {
	@Override
	public ResourceLocation getAnimationResource(GrazerEntity entity) {
		return ResourceLocation.parse("endless_end:animations/grazer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GrazerEntity entity) {
		return ResourceLocation.parse("endless_end:geo/grazer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GrazerEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/" + entity.getTexture() + ".png");
	}

}
