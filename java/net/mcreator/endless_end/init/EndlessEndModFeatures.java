
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
import net.mcreator.endless_end.world.features.SculkSproutPlacementFeature;
import net.mcreator.endless_end.world.features.SculkSinkholePlacementFeature;
import net.mcreator.endless_end.world.features.SculkCraterFeature;
import net.mcreator.endless_end.world.features.ReversedDeltaSpikesFeature;
import net.mcreator.endless_end.world.features.RandomGoldRootsFeature;
import net.mcreator.endless_end.world.features.PoppedChorusBlobFeature;
import net.mcreator.endless_end.world.features.PitfallPlacementFeature;
import net.mcreator.endless_end.world.features.LilBoulderFeature;
import net.mcreator.endless_end.world.features.InvertedOrchardBonusHumusFeature;
import net.mcreator.endless_end.world.features.InvertedHumusFeatureFeature;
import net.mcreator.endless_end.world.features.GrimstoneDepositFeature;
import net.mcreator.endless_end.world.features.GoldenSpikeFeatureFeature;
import net.mcreator.endless_end.world.features.GoldenBlossomFeature;
import net.mcreator.endless_end.world.features.GiantVioletStemFeature;
import net.mcreator.endless_end.world.features.GiantSculkTreePlacementFeature;
import net.mcreator.endless_end.world.features.EndWasteRefuseFeature;
import net.mcreator.endless_end.world.features.ElderBoulderFeature;
import net.mcreator.endless_end.world.features.ChorusBlobFeature;
import net.mcreator.endless_end.world.features.CanticlePatchFeature;
import net.mcreator.endless_end.world.features.BoneSprawlPlacementFeature;
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
	public static final DeferredHolder<Feature<?>, Feature<?>> LIL_BOULDER = REGISTRY.register("lil_boulder", LilBoulderFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SOUL_SPIRE = REGISTRY.register("soul_spire", SoulSpireFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> ELDER_BOULDER = REGISTRY.register("elder_boulder", ElderBoulderFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SCULK_CRATER = REGISTRY.register("sculk_crater", SculkCraterFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> BONE_SPRAWL_PLACEMENT = REGISTRY.register("bone_sprawl_placement", BoneSprawlPlacementFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> REVERSED_DELTA_SPIKES = REGISTRY.register("reversed_delta_spikes", ReversedDeltaSpikesFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> GIANT_VIOLET_STEM = REGISTRY.register("giant_violet_stem", GiantVioletStemFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> GIANT_SCULK_TREE_PLACEMENT = REGISTRY.register("giant_sculk_tree_placement", GiantSculkTreePlacementFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> PITFALL_PLACEMENT = REGISTRY.register("pitfall_placement", PitfallPlacementFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SCULK_SPROUT_PLACEMENT = REGISTRY.register("sculk_sprout_placement", SculkSproutPlacementFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> GRIMSTONE_DEPOSIT = REGISTRY.register("grimstone_deposit", GrimstoneDepositFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> SCULK_SINKHOLE_PLACEMENT = REGISTRY.register("sculk_sinkhole_placement", SculkSinkholePlacementFeature::new);
}
