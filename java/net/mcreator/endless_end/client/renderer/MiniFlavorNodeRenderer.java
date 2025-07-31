
package net.mcreator.endless_end.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.endless_end.entity.MiniFlavorNodeEntity;
import net.mcreator.endless_end.client.model.Modelflavor_node;

public class MiniFlavorNodeRenderer extends MobRenderer<MiniFlavorNodeEntity, Modelflavor_node<MiniFlavorNodeEntity>> {
	public MiniFlavorNodeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelflavor_node<MiniFlavorNodeEntity>(context.bakeLayer(Modelflavor_node.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MiniFlavorNodeEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/flavor_node.png");
	}
}
