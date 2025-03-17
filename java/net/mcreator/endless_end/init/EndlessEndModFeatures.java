
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.world.features.AmethystOreScatterFeature;
import net.mcreator.endless_end.EndlessEndMod;

public class EndlessEndModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, EndlessEndMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> AMETHYST_ORE_SCATTER = REGISTRY.register("amethyst_ore_scatter", AmethystOreScatterFeature::new);
}
