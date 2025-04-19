package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterPurpleTileEntity;

public class EnderporterPurpleBlockModel extends GeoModel<EnderporterPurpleTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterPurpleTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterPurpleTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterPurpleTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_purple.png");
	}
}
