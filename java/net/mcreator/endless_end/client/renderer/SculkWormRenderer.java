
package net.mcreator.endless_end.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SilverfishModel;

import net.mcreator.endless_end.entity.SculkWormEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SculkWormRenderer extends MobRenderer<SculkWormEntity, SilverfishModel<SculkWormEntity>> {
	public SculkWormRenderer(EntityRendererProvider.Context context) {
		super(context, new SilverfishModel<SculkWormEntity>(context.bakeLayer(ModelLayers.SILVERFISH)), 0.5f);
		this.addLayer(new RenderLayer<SculkWormEntity, SilverfishModel<SculkWormEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("endless_end:textures/entities/sculk_worm_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SculkWormEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(SculkWormEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/sculk_worm.png");
	}
}
