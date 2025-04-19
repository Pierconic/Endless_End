package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterDarkGrayTileEntity;

public class EnderporterDarkGrayBlockModel extends GeoModel<EnderporterDarkGrayTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterDarkGrayTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterDarkGrayTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterDarkGrayTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_gray.png");
	}
}
