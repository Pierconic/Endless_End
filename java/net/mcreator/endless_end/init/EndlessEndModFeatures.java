
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.world.features.VioletStemFeature;
import net.mcreator.endless_end.world.features.TrebleShootFeature;
import net.mcreator.endless_end.world.features.SubterraChorusBlobFeature;
import net.mcreator.endless_end.world.features.SoulSpireFeature;
import net.mcreator.endless_end.world.features.SoulDeltaSpikesFeature;
import net.mcreator.endless_end.world.features.SmallVioletStemFeature;
import net.mcreator.endless_end.world.features.RandomGoldRootsFeature;
import net.mcreator.endless_end.world.features.PoppedChorusBlobFeature;
import net.mcreator.endless_end.world.features.InvertedOrchardBonusHumusFeature;
import net.mcreator.endless_end.world.features.InvertedHumusFeatureFeature;
import net.mcreator.endless_end.world.features.GoldenSpikeFeatureFeature;
import net.mcreator.endless_end.world.features.GoldenBlossomFeature;
import net.mcreator.endless_end.world.features.EndWasteRefuseFeature;
import net.mcreator.endless_end.world.features.ChorusBlobFeature;
import net.mcreator.endless_end.world.features.CanticlePatchFeature;
import net.mcreator.endless_end.world.features.AmnesicDepositFeature;
import net.mcreator.endless_end.world.features.AmethystOreScatterFeature;
import net.mcreator.endless_end.EndlessEndMod;

public class EndlessEndModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, EndlessEndMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> AMNESIC_DEPOSIT = REGISTRY.register("amnesic_deposit", AmnesicDepositFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> AMETHYST_ORE_SCATTER = REGISTRY.register("amethyst_ore_scatter", AmethystOreScatterFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> END_WASTE_REFUSE = REGISTRY.register("end_waste_refuse", EndWasteRefuseFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> CANTICLE_PATCH = REGISTRY.register("canticle_patch", CanticlePatchFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> VIOLET_STEM = REGISTRY.register("violet_stem", VioletStemFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> CHORUS_BLOB = REGISTRY.register("chorus_blob", ChorusBlobFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SUBTERRA_CHORUS_BLOB = REGISTRY.register("subterra_chorus_blob", SubterraChorusBlobFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SMALL_VIOLET_STEM = REGISTRY.register("small_violet_stem", SmallVioletStemFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> POPPED_CHORUS_BLOB = REGISTRY.register("popped_chorus_blob", PoppedChorusBlobFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> GOLDEN_BLOSSOM = REGISTRY.register("golden_blossom", GoldenBlossomFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> TREBLE_SHOOT = REGISTRY.register("treble_shoot", TrebleShootFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> INVERTED_HUMUS_FEATURE = REGISTRY.register("inverted_humus_feature", InvertedHumusFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> GOLDEN_SPIKE_FEATURE = REGISTRY.register("golden_spike_feature", GoldenSpikeFeatureFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> INVERTED_ORCHARD_BONUS_HUMUS = REGISTRY.register("inverted_orchard_bonus_humus", InvertedOrchardBonusHumusFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> RANDOM_GOLD_ROOTS = REGISTRY.register("random_gold_roots", RandomGoldRootsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SOUL_DELTA_SPIKES = REGISTRY.register("soul_delta_spikes", SoulDeltaSpikesFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SOUL_SPIRE = REGISTRY.register("soul_spire", SoulSpireFeature::new);
}
