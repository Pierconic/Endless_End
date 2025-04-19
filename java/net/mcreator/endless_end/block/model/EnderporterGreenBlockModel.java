package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterGreenTileEntity;

public class EnderporterGreenBlockModel extends GeoModel<EnderporterGreenTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterGreenTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterGreenTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterGreenTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_green.png");
	}
}
