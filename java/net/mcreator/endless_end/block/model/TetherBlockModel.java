package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.TetherTileEntity;

public class TetherBlockModel extends GeoModel<TetherTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(TetherTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/tether.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TetherTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/tether.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TetherTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/tether.png");
	}
}
