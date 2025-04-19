package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterBlueTileEntity;

public class EnderporterBlueBlockModel extends GeoModel<EnderporterBlueTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterBlueTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterBlueTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterBlueTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_blue.png");
	}
}
