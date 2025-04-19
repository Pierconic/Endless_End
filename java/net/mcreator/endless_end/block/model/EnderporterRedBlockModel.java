package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterRedTileEntity;

public class EnderporterRedBlockModel extends GeoModel<EnderporterRedTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterRedTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterRedTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterRedTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_red.png");
	}
}
