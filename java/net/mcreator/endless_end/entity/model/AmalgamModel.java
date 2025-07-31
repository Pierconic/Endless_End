package net.mcreator.endless_end.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.entity.AmalgamEntity;

public class AmalgamModel extends GeoModel<AmalgamEntity> {
	@Override
	public ResourceLocation getAnimationResource(AmalgamEntity entity) {
		return ResourceLocation.parse("endless_end:animations/amalgam.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AmalgamEntity entity) {
		return ResourceLocation.parse("endless_end:geo/amalgam.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AmalgamEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/" + entity.getTexture() + ".png");
	}

}
