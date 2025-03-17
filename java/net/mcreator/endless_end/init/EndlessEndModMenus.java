
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.world.inventory.TransceiverInterfaceMenu;
import net.mcreator.endless_end.EndlessEndMod;

public class EndlessEndModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, EndlessEndMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<TransceiverInterfaceMenu>> TRANSCEIVER_INTERFACE = REGISTRY.register("transceiver_interface", () -> IMenuTypeExtension.create(TransceiverInterfaceMenu::new));
}
