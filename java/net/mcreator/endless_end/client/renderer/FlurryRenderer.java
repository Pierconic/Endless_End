
package net.mcreator.endless_end.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.entity.model.FlurryModel;
import net.mcreator.endless_end.entity.FlurryEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FlurryRenderer extends GeoEntityRenderer<FlurryEntity> {
	public FlurryRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FlurryModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(FlurryEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	 protected int getBlockLightLevel(FlurryEntity entity, BlockPos pos) {
        return 15;
    }

	@Override
	public void preRender(PoseStack poseStack, FlurryEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}
}
