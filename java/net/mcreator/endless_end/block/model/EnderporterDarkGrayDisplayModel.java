package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterDarkGrayDisplayItem;

public class EnderporterDarkGrayDisplayModel extends GeoModel<EnderporterDarkGrayDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterDarkGrayDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterDarkGrayDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterDarkGrayDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_gray.png");
	}
}
