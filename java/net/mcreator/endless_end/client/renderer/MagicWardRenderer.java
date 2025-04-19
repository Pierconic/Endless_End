
package net.mcreator.endless_end.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.endless_end.entity.MagicWardEntity;
import net.mcreator.endless_end.client.model.Modelward;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MagicWardRenderer extends MobRenderer<MagicWardEntity, Modelward<MagicWardEntity>> {
	public MagicWardRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelward<MagicWardEntity>(context.bakeLayer(Modelward.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<MagicWardEntity, Modelward<MagicWardEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("endless_end:textures/entities/ward_texture.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MagicWardEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modelward(Minecraft.getInstance().getEntityModels().bakeLayer(Modelward.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(MagicWardEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/ward_texture.png");
	}
}
