
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.endless_end.fluid.types.EssenceFluidType;
import net.mcreator.endless_end.EndlessEndMod;

public class EndlessEndModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, EndlessEndMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> ESSENCE_TYPE = REGISTRY.register("essence", () -> new EssenceFluidType());
}
