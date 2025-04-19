package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterBlackDisplayItem;

public class EnderporterBlackDisplayModel extends GeoModel<EnderporterBlackDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterBlackDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterBlackDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterBlackDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_black.png");
	}
}
