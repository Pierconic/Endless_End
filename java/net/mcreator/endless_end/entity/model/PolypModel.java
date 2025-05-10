package net.mcreator.endless_end.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.entity.PolypEntity;

public class PolypModel extends GeoModel<PolypEntity> {
	@Override
	public ResourceLocation getAnimationResource(PolypEntity entity) {
		return ResourceLocation.parse("endless_end:animations/polyp.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PolypEntity entity) {
		return ResourceLocation.parse("endless_end:geo/polyp.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PolypEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/" + entity.getTexture() + ".png");
	}

}
