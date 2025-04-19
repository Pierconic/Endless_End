package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterBrownDisplayItem;

public class EnderporterBrownDisplayModel extends GeoModel<EnderporterBrownDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterBrownDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterBrownDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterBrownDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_brown.png");
	}
}
