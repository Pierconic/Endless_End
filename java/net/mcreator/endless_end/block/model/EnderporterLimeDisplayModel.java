package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterLimeDisplayItem;

public class EnderporterLimeDisplayModel extends GeoModel<EnderporterLimeDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterLimeDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterLimeDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterLimeDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_lime.png");
	}
}
