
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.world.features.VioletStemFeature;
import net.mcreator.endless_end.world.features.SubterraChorusBlobFeature;
import net.mcreator.endless_end.world.features.SmallVioletStemFeature;
import net.mcreator.endless_end.world.features.PoppedChorusBlobFeature;
import net.mcreator.endless_end.world.features.EndWasteRefuseFeature;
import net.mcreator.endless_end.world.features.ChorusBlobFeature;
import net.mcreator.endless_end.world.features.CanticlePatchFeature;
import net.mcreator.endless_end.world.features.AmethystOreScatterFeature;
import net.mcreator.endless_end.EndlessEndMod;

public class EndlessEndModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, EndlessEndMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> AMETHYST_ORE_SCATTER = REGISTRY.register("amethyst_ore_scatter", AmethystOreScatterFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> END_WASTE_REFUSE = REGISTRY.register("end_waste_refuse", EndWasteRefuseFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> CANTICLE_PATCH = REGISTRY.register("canticle_patch", CanticlePatchFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> VIOLET_STEM = REGISTRY.register("violet_stem", VioletStemFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> CHORUS_BLOB = REGISTRY.register("chorus_blob", ChorusBlobFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SUBTERRA_CHORUS_BLOB = REGISTRY.register("subterra_chorus_blob", SubterraChorusBlobFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SMALL_VIOLET_STEM = REGISTRY.register("small_violet_stem", SmallVioletStemFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> POPPED_CHORUS_BLOB = REGISTRY.register("popped_chorus_blob", PoppedChorusBlobFeature::new);
}
