package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterLightGrayDisplayItem;

public class EnderporterLightGrayDisplayModel extends GeoModel<EnderporterLightGrayDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterLightGrayDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterLightGrayDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterLightGrayDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_light_gray.png");
	}
}
