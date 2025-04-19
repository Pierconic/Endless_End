package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterRedDisplayItem;

public class EnderporterRedDisplayModel extends GeoModel<EnderporterRedDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterRedDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterRedDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterRedDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_red.png");
	}
}
