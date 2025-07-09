package net.mcreator.endless_end.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.entity.FlurryChargeEntityEntity;

public class FlurryChargeEntityModel extends GeoModel<FlurryChargeEntityEntity> {
	@Override
	public ResourceLocation getAnimationResource(FlurryChargeEntityEntity entity) {
		return ResourceLocation.parse("endless_end:animations/flurry_charge.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FlurryChargeEntityEntity entity) {
		return ResourceLocation.parse("endless_end:geo/flurry_charge.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FlurryChargeEntityEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/" + entity.getTexture() + ".png");
	}

}
