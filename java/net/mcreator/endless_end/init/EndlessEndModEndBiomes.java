package net.mcreator.endless_end.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.endbiomes.TheEndBiomes;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class EndlessEndModEndBiomes {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TheEndBiomes.addHighlandsBiome(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:chorus_orchard")), 0.8d);
			TheEndBiomes.addMidlandsBiome(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:chorus_orchard")), ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:chorus_midlands")), 1d);
			TheEndBiomes.addBarrensBiome(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:chorus_orchard")), ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:chorus_barrens")), 1.2d);
			TheEndBiomes.addHighlandsBiome(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:inverted_orchard")), 1d);
			TheEndBiomes.addMidlandsBiome(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:inverted_orchard")), ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:inverted_midlands")), 1d);
			TheEndBiomes.addBarrensBiome(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:inverted_orchard")), ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:inverted_barrens")), 1d);
			TheEndBiomes.addHighlandsBiome(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:whispering_delta")), 1d);
			TheEndBiomes.addMidlandsBiome(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:whispering_delta")), ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:whispering_delta")), 1d);
			TheEndBiomes.addBarrensBiome(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:whispering_delta")), ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:whispering_delta")), 1d);
			TheEndBiomes.addHighlandsBiome(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:soul_arbor")), 1d);
			TheEndBiomes.addMidlandsBiome(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:soul_arbor")), ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:soul_arbor")), 1d);
			TheEndBiomes.addBarrensBiome(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:soul_arbor")), ResourceKey.create(Registries.BIOME, ResourceLocation.parse("endless_end:soul_arbor")), 1d);
		});
	}
}
