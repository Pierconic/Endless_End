
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.endless_end.client.model.Modelweaver_spit;
import net.mcreator.endless_end.client.model.Modelward;
import net.mcreator.endless_end.client.model.Modelswingsilk_ball;
import net.mcreator.endless_end.client.model.Modelswing_shot_bolt;
import net.mcreator.endless_end.client.model.Modelloomer_bolt;
import net.mcreator.endless_end.client.model.Modelhookshot_ball;
import net.mcreator.endless_end.client.model.Modelflavor_node;
import net.mcreator.endless_end.client.model.Modelchain_link;
import net.mcreator.endless_end.client.model.Modelchain_ball;
import net.mcreator.endless_end.client.model.Modelbeam_model;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EndlessEndModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelswingsilk_ball.LAYER_LOCATION, Modelswingsilk_ball::createBodyLayer);
		event.registerLayerDefinition(Modelchain_link.LAYER_LOCATION, Modelchain_link::createBodyLayer);
		event.registerLayerDefinition(Modelward.LAYER_LOCATION, Modelward::createBodyLayer);
		event.registerLayerDefinition(Modelbeam_model.LAYER_LOCATION, Modelbeam_model::createBodyLayer);
		event.registerLayerDefinition(Modelflavor_node.LAYER_LOCATION, Modelflavor_node::createBodyLayer);
		event.registerLayerDefinition(Modelweaver_spit.LAYER_LOCATION, Modelweaver_spit::createBodyLayer);
		event.registerLayerDefinition(Modelhookshot_ball.LAYER_LOCATION, Modelhookshot_ball::createBodyLayer);
		event.registerLayerDefinition(Modelswing_shot_bolt.LAYER_LOCATION, Modelswing_shot_bolt::createBodyLayer);
		event.registerLayerDefinition(Modelloomer_bolt.LAYER_LOCATION, Modelloomer_bolt::createBodyLayer);
		event.registerLayerDefinition(Modelchain_ball.LAYER_LOCATION, Modelchain_ball::createBodyLayer);
	}
}
