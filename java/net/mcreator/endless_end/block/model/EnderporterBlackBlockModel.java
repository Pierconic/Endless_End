package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterBlackTileEntity;

public class EnderporterBlackBlockModel extends GeoModel<EnderporterBlackTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterBlackTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterBlackTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterBlackTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_black.png");
	}
}
