package net.mcreator.endless_end.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.entity.WeaverEntity;

public class WeaverModel extends GeoModel<WeaverEntity> {
	@Override
	public ResourceLocation getAnimationResource(WeaverEntity entity) {
		return ResourceLocation.parse("endless_end:animations/weaver.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WeaverEntity entity) {
		return ResourceLocation.parse("endless_end:geo/weaver.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WeaverEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/" + entity.getTexture() + ".png");
	}

}
