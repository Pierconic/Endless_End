package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterCyanTileEntity;

public class EnderporterCyanBlockModel extends GeoModel<EnderporterCyanTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterCyanTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterCyanTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterCyanTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_cyan.png");
	}
}
