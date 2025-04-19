package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.display.EnderporterMagentaDisplayItem;

public class EnderporterMagentaDisplayModel extends GeoModel<EnderporterMagentaDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterMagentaDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterMagentaDisplayItem animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterMagentaDisplayItem entity) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_magenta.png");
	}
}
