package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterOrangeDisplayItem;

public class EnderporterOrangeDisplayModel extends GeoModel<EnderporterOrangeDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterOrangeDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterOrangeDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterOrangeDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_orange.png");
	}
}
