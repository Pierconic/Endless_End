package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterYellowTileEntity;

public class EnderporterYellowBlockModel extends GeoModel<EnderporterYellowTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterYellowTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterYellowTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterYellowTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_yellow.png");
	}
}
