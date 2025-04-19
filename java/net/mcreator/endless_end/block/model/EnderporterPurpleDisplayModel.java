package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterPurpleDisplayItem;

public class EnderporterPurpleDisplayModel extends GeoModel<EnderporterPurpleDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterPurpleDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterPurpleDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterPurpleDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_purple.png");
	}
}
