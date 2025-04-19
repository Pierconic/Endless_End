package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterCyanDisplayItem;

public class EnderporterCyanDisplayModel extends GeoModel<EnderporterCyanDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterCyanDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterCyanDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterCyanDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_cyan.png");
	}
}
