package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterLightBlueTileEntity;

public class EnderporterLightBlueBlockModel extends GeoModel<EnderporterLightBlueTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterLightBlueTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterLightBlueTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterLightBlueTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_light_blue.png");
	}
}
