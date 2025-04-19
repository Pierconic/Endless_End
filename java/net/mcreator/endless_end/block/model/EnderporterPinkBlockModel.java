package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterPinkTileEntity;

public class EnderporterPinkBlockModel extends GeoModel<EnderporterPinkTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterPinkTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterPinkTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterPinkTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_pink.png");
	}
}
