package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterWhiteDisplayItem;

public class EnderporterWhiteDisplayModel extends GeoModel<EnderporterWhiteDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterWhiteDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterWhiteDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterWhiteDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_white.png");
	}
}
