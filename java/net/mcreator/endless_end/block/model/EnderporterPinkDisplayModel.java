package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterPinkDisplayItem;

public class EnderporterPinkDisplayModel extends GeoModel<EnderporterPinkDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterPinkDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterPinkDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterPinkDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_pink.png");
	}
}
