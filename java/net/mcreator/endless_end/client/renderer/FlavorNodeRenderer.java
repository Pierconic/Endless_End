
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

import net.mcreator.endless_end.entity.FlavorNodeEntity;
import net.mcreator.endless_end.client.model.Modelflavor_node;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FlavorNodeRenderer extends MobRenderer<FlavorNodeEntity, Modelflavor_node<FlavorNodeEntity>> {
	public FlavorNodeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelflavor_node(context.bakeLayer(Modelflavor_node.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<FlavorNodeEntity, Modelflavor_node<FlavorNodeEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("endless_end:textures/entities/flavor_node.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FlavorNodeEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modelflavor_node(Minecraft.getInstance().getEntityModels().bakeLayer(Modelflavor_node.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(FlavorNodeEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/flavor_node.png");
	}
}
