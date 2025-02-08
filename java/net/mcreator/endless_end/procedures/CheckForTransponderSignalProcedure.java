package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModItems;

import java.util.ArrayList;

public class CheckForTransponderSignalProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		ItemStack handtransponder = ItemStack.EMPTY;
		ItemStack newtransponder = ItemStack.EMPTY;
		double slot = 0;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			slot = 0;
			for (int index0 = 0; index0 < 36; index0++) {
				if ((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							return _modHandler.getStackInSlot(sltid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) slot, entityiterator)).getItem() == EndlessEndModItems.SENDING_TRANSPONDER.get() && ((((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							return _modHandler.getStackInSlot(sltid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) slot, entityiterator)).getDisplayName().getString()).replace("]", "")).replace("[", "")).equals((((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), 0)).getDisplayName().getString()).replace("]", "")).replace("[", ""))) {
					found = true;
				}
				slot = slot + 1;
			}
		}
		if (found) {
			return true;
		}
		return false;
	}
}
