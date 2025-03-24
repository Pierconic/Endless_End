
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.EndlessEndMod;

public class EndlessEndModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, EndlessEndMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> PLACEPOTTERY = REGISTRY.register("placepottery", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "placepottery")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HITPOTTERY = REGISTRY.register("hitpottery", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "hitpottery")));
	public static final DeferredHolder<SoundEvent, SoundEvent> STEPPORCELAIN = REGISTRY.register("stepporcelain", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "stepporcelain")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BREAKPORCELAIN = REGISTRY.register("breakporcelain", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "breakporcelain")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BREAKCERAMIC = REGISTRY.register("breakceramic", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "breakceramic")));
	public static final DeferredHolder<SoundEvent, SoundEvent> INTRO = REGISTRY.register("intro", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "intro")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MACHINECHIRPS = REGISTRY.register("machinechirps", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "machinechirps")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MACHINESENSES = REGISTRY.register("machinesenses", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "machinesenses")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MACHINERYBEEP = REGISTRY.register("machinerybeep", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "machinerybeep")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ENDORITESENSE = REGISTRY.register("endoritesense", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "endoritesense")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ENDORITEPLACE = REGISTRY.register("endoriteplace", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "endoriteplace")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ENDORITEBREAK = REGISTRY.register("endoritebreak", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "endoritebreak")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ENDORITEPHASE = REGISTRY.register("endoritephase", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "endoritephase")));
	public static final DeferredHolder<SoundEvent, SoundEvent> RANDOMTELEPORT = REGISTRY.register("randomteleport", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "randomteleport")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TRANSPONDER_TRANSMISSION_SUCCESS = REGISTRY.register("transponder.transmission.success",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "transponder.transmission.success")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TRANSPONDER_TRANSMISSION_FAILURE = REGISTRY.register("transponder.transmission.failure",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "transponder.transmission.failure")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TRANSPONDER_TRANSMISSION_ON = REGISTRY.register("transponder.transmission.on",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "transponder.transmission.on")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TRANSPONDER_TRANSMISSION_OFF = REGISTRY.register("transponder.transmission.off",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "transponder.transmission.off")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SILENCE = REGISTRY.register("silence", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "silence")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_COPPER_BULB_PLACE = REGISTRY.register("block.copper_bulb.place",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "block.copper_bulb.place")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_COPPER_BULB_BREAK = REGISTRY.register("block.copper_bulb.break",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "block.copper_bulb.break")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_COPPER_BULB_STEP = REGISTRY.register("block.copper_bulb.step",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "block.copper_bulb.step")));
	public static final DeferredHolder<SoundEvent, SoundEvent> COPPER_BULB_ACTIVATE = REGISTRY.register("copper_bulb_activate", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "copper_bulb_activate")));
	public static final DeferredHolder<SoundEvent, SoundEvent> COPPER_BULB_DEACTIVATE = REGISTRY.register("copper_bulb_deactivate",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "copper_bulb_deactivate")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MEMBRANE_POWER = REGISTRY.register("membrane.power", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "membrane.power")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MEMBRANE_DEPOWER = REGISTRY.register("membrane.depower", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "membrane.depower")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MEMBRANE_PULSE = REGISTRY.register("membrane.pulse", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "membrane.pulse")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ASCENSION = REGISTRY.register("ascension", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "ascension")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ETHER_FREEZE = REGISTRY.register("ether.freeze", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "ether.freeze")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ETHER_SOLIDIFY = REGISTRY.register("ether.solidify", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "ether.solidify")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LYDIAN_EMERGE = REGISTRY.register("lydian.emerge", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lydian.emerge")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LYDIAN_RETRACT = REGISTRY.register("lydian.retract", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lydian.retract")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LYDIAN_TUNNEL = REGISTRY.register("lydian.tunnel", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lydian.tunnel")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DISC_ELEGY = REGISTRY.register("disc.elegy", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "disc.elegy")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ESSENCE_EMPTY = REGISTRY.register("essence.empty", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "essence.empty")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ESSENCE_BUBBLE = REGISTRY.register("essence.bubble", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "essence.bubble")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ESSENCE_PLUME = REGISTRY.register("essence.plume", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "essence.plume")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ELEVEN_REPAIRED = REGISTRY.register("eleven_repaired", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "eleven_repaired")));
	public static final DeferredHolder<SoundEvent, SoundEvent> YEARNING_EYE_FAR = REGISTRY.register("yearning_eye.far", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "yearning_eye.far")));
	public static final DeferredHolder<SoundEvent, SoundEvent> YEARNING_EYE_CLOSER = REGISTRY.register("yearning_eye.closer", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "yearning_eye.closer")));
	public static final DeferredHolder<SoundEvent, SoundEvent> YEARNING_EYE_NEAR = REGISTRY.register("yearning_eye.near", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "yearning_eye.near")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EYE_CHARGE = REGISTRY.register("eye.charge", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "eye.charge")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HOLLOW_SCREECH = REGISTRY.register("hollow.screech", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "hollow.screech")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HOLLOW_HEARTBEAT = REGISTRY.register("hollow.heartbeat", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "hollow.heartbeat")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HOLLOW_HURT = REGISTRY.register("hollow.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "hollow.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HOLLOW_STEP = REGISTRY.register("hollow.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "hollow.step")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HOLLOW_DEATH = REGISTRY.register("hollow.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "hollow.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SCULK_MANIFEST = REGISTRY.register("sculk.manifest", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "sculk.manifest")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SCULK_STAB = REGISTRY.register("sculk.stab", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "sculk.stab")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLUE_ROSE_MANIFEST = REGISTRY.register("blue_rose.manifest", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "blue_rose.manifest")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SINGING_SAND_PLACE = REGISTRY.register("singing_sand.place", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "singing_sand.place")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EXP_LEECH_SMALL = REGISTRY.register("exp.leech.small", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "exp.leech.small")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EXP_LEECH_MEDIUM = REGISTRY.register("exp.leech.medium", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "exp.leech.medium")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EXP_LEECH_LARGE = REGISTRY.register("exp.leech.large", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "exp.leech.large")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EXP_LEECH_FINAL = REGISTRY.register("exp.leech.final", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "exp.leech.final")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_AMNESOCLAST_STEP = REGISTRY.register("block.amnesoclast.step",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "block.amnesoclast.step")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ICONOCLAST_TWIST = REGISTRY.register("iconoclast.twist", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "iconoclast.twist")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_AMNESOCLAST_BREAK = REGISTRY.register("block.amnesoclast.break",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "block.amnesoclast.break")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_AMNESOCLAST_DIG = REGISTRY.register("block.amnesoclast.dig",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "block.amnesoclast.dig")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_AMNESOCLAST_PLACE = REGISTRY.register("block.amnesoclast.place",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "block.amnesoclast.place")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AMNESOCLAST_MEMORY = REGISTRY.register("amnesoclast.memory", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "amnesoclast.memory")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AMNESOCLAST_SHIFT = REGISTRY.register("amnesoclast.shift", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "amnesoclast.shift")));
	public static final DeferredHolder<SoundEvent, SoundEvent> YEARNING_EYE_CHARGE = REGISTRY.register("yearning_eye.charge", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "yearning_eye.charge")));
	public static final DeferredHolder<SoundEvent, SoundEvent> REFUSE_STEP = REGISTRY.register("refuse_step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "refuse_step")));
	public static final DeferredHolder<SoundEvent, SoundEvent> REFUSE_SNAP = REGISTRY.register("refuse_snap", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "refuse_snap")));
	public static final DeferredHolder<SoundEvent, SoundEvent> REFUSE_PLACE = REGISTRY.register("refuse_place", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "refuse_place")));
	public static final DeferredHolder<SoundEvent, SoundEvent> REFUSE_HIT = REGISTRY.register("refuse_hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "refuse_hit")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_1 = REGISTRY.register("lead_wood_1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_2 = REGISTRY.register("lead_wood_2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_3 = REGISTRY.register("lead_wood_3", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_3")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_4 = REGISTRY.register("lead_wood_4", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_4")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_5 = REGISTRY.register("lead_wood_5", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_5")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_6 = REGISTRY.register("lead_wood_6", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_6")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_7 = REGISTRY.register("lead_wood_7", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_7")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_8 = REGISTRY.register("lead_wood_8", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_8")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_9 = REGISTRY.register("lead_wood_9", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_9")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_10 = REGISTRY.register("lead_wood_10", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_10")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_11 = REGISTRY.register("lead_wood_11", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_11")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_12 = REGISTRY.register("lead_wood_12", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_12")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_WOOD_13 = REGISTRY.register("lead_wood_13", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_wood_13")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_1 = REGISTRY.register("loop_wood_1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_2 = REGISTRY.register("loop_wood_2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_3 = REGISTRY.register("loop_wood_3", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_3")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_4 = REGISTRY.register("loop_wood_4", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_4")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_5 = REGISTRY.register("loop_wood_5", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_5")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_6 = REGISTRY.register("loop_wood_6", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_6")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_7 = REGISTRY.register("loop_wood_7", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_7")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_8 = REGISTRY.register("loop_wood_8", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_8")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_9 = REGISTRY.register("loop_wood_9", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_9")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_10 = REGISTRY.register("loop_wood_10", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_10")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_11 = REGISTRY.register("loop_wood_11", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_11")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_12 = REGISTRY.register("loop_wood_12", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_12")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_WOOD_13 = REGISTRY.register("loop_wood_13", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_wood_13")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_1 = REGISTRY.register("lead_stone_1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_2 = REGISTRY.register("lead_stone_2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_3 = REGISTRY.register("lead_stone_3", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_3")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_4 = REGISTRY.register("lead_stone_4", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_4")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_5 = REGISTRY.register("lead_stone_5", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_5")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_6 = REGISTRY.register("lead_stone_6", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_6")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_7 = REGISTRY.register("lead_stone_7", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_7")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_8 = REGISTRY.register("lead_stone_8", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_8")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_9 = REGISTRY.register("lead_stone_9", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_9")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_10 = REGISTRY.register("lead_stone_10", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_10")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_11 = REGISTRY.register("lead_stone_11", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_11")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_12 = REGISTRY.register("lead_stone_12", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_12")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEAD_STONE_13 = REGISTRY.register("lead_stone_13", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "lead_stone_13")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_1 = REGISTRY.register("loop_stone_1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_2 = REGISTRY.register("loop_stone_2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_3 = REGISTRY.register("loop_stone_3", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_3")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_4 = REGISTRY.register("loop_stone_4", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_4")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_5 = REGISTRY.register("loop_stone_5", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_5")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_6 = REGISTRY.register("loop_stone_6", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_6")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_7 = REGISTRY.register("loop_stone_7", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_7")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_8 = REGISTRY.register("loop_stone_8", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_8")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_9 = REGISTRY.register("loop_stone_9", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_9")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_11 = REGISTRY.register("loop_stone_11", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_11")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_12 = REGISTRY.register("loop_stone_12", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_12")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_13 = REGISTRY.register("loop_stone_13", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_13")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOOP_STONE_10 = REGISTRY.register("loop_stone_10", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "loop_stone_10")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ADAMANT_HIT = REGISTRY.register("adamant.hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "adamant.hit")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ADAMANT_BREAK = REGISTRY.register("adamant.break", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "adamant.break")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ADAMANT_STEP = REGISTRY.register("adamant.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "adamant.step")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ADAMANT_PLACE = REGISTRY.register("adamant.place", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "adamant.place")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOON_JUMP = REGISTRY.register("moon_jump", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "moon_jump")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOON_BOUNCE = REGISTRY.register("moon_bounce", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "moon_bounce")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EYE_STRIKE = REGISTRY.register("eye_strike", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "eye_strike")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CHORUS_ORCHARD_AMBIENT = REGISTRY.register("chorus_orchard_ambient",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "chorus_orchard_ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CHORUS_MOOD = REGISTRY.register("chorus_mood", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "chorus_mood")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CHORUS_ADDITIONS = REGISTRY.register("chorus_additions", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("endless_end", "chorus_additions")));
}
