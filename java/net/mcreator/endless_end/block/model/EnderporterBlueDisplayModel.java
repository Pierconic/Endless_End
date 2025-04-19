package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterBlueDisplayItem;

public class EnderporterBlueDisplayModel extends GeoModel<EnderporterBlueDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterBlueDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterBlueDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterBlueDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_blue.png");
	}
}
