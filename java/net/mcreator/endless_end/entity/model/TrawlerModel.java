package net.mcreator.endless_end.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.entity.TrawlerEntity;

public class TrawlerModel extends GeoModel<TrawlerEntity> {
	@Override
	public ResourceLocation getAnimationResource(TrawlerEntity entity) {
		return ResourceLocation.parse("endless_end:animations/trawler.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TrawlerEntity entity) {
		return ResourceLocation.parse("endless_end:geo/trawler.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TrawlerEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/" + entity.getTexture() + ".png");
	}

}
