package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.PuffBlossomTileEntity;

public class PuffBlossomBlockModel extends GeoModel<PuffBlossomTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(PuffBlossomTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/puff_blossom.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PuffBlossomTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/puff_blossom.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PuffBlossomTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/puff_blossom.png");
	}
}
