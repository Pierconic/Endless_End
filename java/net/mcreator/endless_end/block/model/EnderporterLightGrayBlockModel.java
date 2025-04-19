package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterLightGrayTileEntity;

public class EnderporterLightGrayBlockModel extends GeoModel<EnderporterLightGrayTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterLightGrayTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterLightGrayTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterLightGrayTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_light_gray.png");
	}
}
