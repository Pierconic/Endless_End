package net.mcreator.endless_end.init;

import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.mixins.NoiseGeneratorSettingsAccess;

@EventBusSubscriber
public class EndlessEndModSurfaceRules {
	@SubscribeEvent
	public static void init(ServerAboutToStartEvent event) {
		LevelStem levelStem = event.getServer().registryAccess().registryOrThrow(Registries.LEVEL_STEM).get(LevelStem.END);
		ChunkGenerator chunkGenerator = levelStem.generator();
		boolean hasEndBiomes = chunkGenerator.getBiomeSource().possibleBiomes().stream().anyMatch(biomeHolder -> biomeHolder.unwrapKey().orElseThrow().location().getNamespace().equals("endless_end"));
		if (hasEndBiomes) {
			if (chunkGenerator instanceof NoiseBasedChunkGenerator generator) {
				NoiseGeneratorSettings noiseGeneratorSettings = generator.settings.value();
				registerSurfaceRules(ResourceLocation.parse("endless_end:chorus_orchard"), noiseGeneratorSettings, EndlessEndModBlocks.CANTICLE.get().defaultBlockState(), Blocks.END_STONE.defaultBlockState());
				registerSurfaceRules(ResourceLocation.parse("endless_end:chorus_midlands"), noiseGeneratorSettings, Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
				registerSurfaceRules(ResourceLocation.parse("endless_end:chorus_barrens"), noiseGeneratorSettings, Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
				registerSurfaceRules(ResourceLocation.parse("endless_end:inverted_orchard"), noiseGeneratorSettings, Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
				registerSurfaceRules(ResourceLocation.parse("endless_end:inverted_midlands"), noiseGeneratorSettings, Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
				registerSurfaceRules(ResourceLocation.parse("endless_end:inverted_barrens"), noiseGeneratorSettings, Blocks.END_STONE.defaultBlockState(), Blocks.END_STONE.defaultBlockState());
				registerSurfaceRules(ResourceLocation.parse("endless_end:whispering_delta"), noiseGeneratorSettings, EndlessEndModBlocks.CALCIFIED_ENDSTONE.get().defaultBlockState(), Blocks.END_STONE.defaultBlockState());
				registerSurfaceRules(ResourceLocation.parse("endless_end:soul_arbor"), noiseGeneratorSettings, Blocks.SMOOTH_BASALT.defaultBlockState(), EndlessEndModBlocks.GRIM_STONE.get().defaultBlockState());
				registerSurfaceRules(ResourceLocation.parse("endless_end:soul_arbor_midlands"), noiseGeneratorSettings, Blocks.SMOOTH_BASALT.defaultBlockState(), EndlessEndModBlocks.GRIM_STONE.get().defaultBlockState());
				registerSurfaceRules(ResourceLocation.parse("endless_end:soul_arbor_barrens"), noiseGeneratorSettings, Blocks.SMOOTH_BASALT.defaultBlockState(), EndlessEndModBlocks.GRIM_STONE.get().defaultBlockState());
			}
		}
	}

	public static void registerSurfaceRules(ResourceLocation biome, NoiseGeneratorSettings noiseGeneratorSettings, BlockState groundBlock, BlockState undergroundBlock) {
		((NoiseGeneratorSettingsAccess) (Object) noiseGeneratorSettings).addSurfaceRule(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ResourceKey.create(Registries.BIOME, biome)),
				SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(groundBlock)), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(undergroundBlock)))), noiseGeneratorSettings.surfaceRule()));
	}
}
