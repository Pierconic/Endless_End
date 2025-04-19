
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.endless_end.client.model.Modelward;
import net.mcreator.endless_end.client.model.Modelflavor_node;
import net.mcreator.endless_end.client.model.Modelbeam_model;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EndlessEndModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelward.LAYER_LOCATION, Modelward::createBodyLayer);
		event.registerLayerDefinition(Modelbeam_model.LAYER_LOCATION, Modelbeam_model::createBodyLayer);
		event.registerLayerDefinition(Modelflavor_node.LAYER_LOCATION, Modelflavor_node::createBodyLayer);
	}
}
