package net.mcreator.endless_end.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.entity.VioletPolypEntity;

public class VioletPolypModel extends GeoModel<VioletPolypEntity> {
	@Override
	public ResourceLocation getAnimationResource(VioletPolypEntity entity) {
		return ResourceLocation.parse("endless_end:animations/polyp.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VioletPolypEntity entity) {
		return ResourceLocation.parse("endless_end:geo/polyp.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VioletPolypEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/" + entity.getTexture() + ".png");
	}

}
