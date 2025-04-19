package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterLightBlueDisplayItem;

public class EnderporterLightBlueDisplayModel extends GeoModel<EnderporterLightBlueDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterLightBlueDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterLightBlueDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterLightBlueDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_light_blue.png");
	}
}
