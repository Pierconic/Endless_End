package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterYellowDisplayItem;

public class EnderporterYellowDisplayModel extends GeoModel<EnderporterYellowDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterYellowDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterYellowDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterYellowDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_yellow.png");
	}
}
