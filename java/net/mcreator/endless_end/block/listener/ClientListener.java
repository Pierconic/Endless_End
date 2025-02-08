package net.mcreator.endless_end.block.listener;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.entity.BlockEntityType;

import net.mcreator.endless_end.init.EndlessEndModBlockEntities;
import net.mcreator.endless_end.block.renderer.TetherTileRenderer;
import net.mcreator.endless_end.block.entity.TetherTileEntity;
import net.mcreator.endless_end.EndlessEndMod;

@EventBusSubscriber(modid = EndlessEndMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer((BlockEntityType<TetherTileEntity>) EndlessEndModBlockEntities.TETHER.get(), context -> new TetherTileRenderer());
	}
}
