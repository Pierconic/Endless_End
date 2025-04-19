package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterGreenDisplayItem;

public class EnderporterGreenDisplayModel extends GeoModel<EnderporterGreenDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterGreenDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterGreenDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterGreenDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_green.png");
	}
}
