package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterWhiteTileEntity;

public class EnderporterWhiteBlockModel extends GeoModel<EnderporterWhiteTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterWhiteTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterWhiteTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterWhiteTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_white.png");
	}
}
