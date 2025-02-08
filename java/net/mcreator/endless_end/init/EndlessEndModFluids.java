
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.endless_end.fluid.EssenceFluid;
import net.mcreator.endless_end.EndlessEndMod;

public class EndlessEndModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, EndlessEndMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> ESSENCE = REGISTRY.register("essence", () -> new EssenceFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ESSENCE = REGISTRY.register("flowing_essence", () -> new EssenceFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(ESSENCE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ESSENCE.get(), RenderType.translucent());
		}
	}
}
