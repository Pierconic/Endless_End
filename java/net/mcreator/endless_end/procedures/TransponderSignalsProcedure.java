package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModItems;

import java.util.ArrayList;

public class TransponderSignalsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double slot = 0;
		ItemStack newtransponder = ItemStack.EMPTY;
		ItemStack handtransponder = ItemStack.EMPTY;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == EndlessEndModItems.PULSING_TRANSPONDER.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == EndlessEndModItems.TRANSPONDER.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == EndlessEndModItems.SENDING_TRANSPONDER.get())) {
			newtransponder = new ItemStack(EndlessEndModItems.PULSING_TRANSPONDER.get());
			handtransponder = new ItemStack(EndlessEndModItems.SENDING_TRANSPONDER.get());
			newtransponder.set(DataComponents.CUSTOM_NAME, Component.literal((((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", ""))));
			handtransponder.set(DataComponents.CUSTOM_NAME, Component.literal((((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", ""))));
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = handtransponder.copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:transponder.transmission.on")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:transponder.transmission.on")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			found = false;
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (!(entity == entityiterator)) {
					slot = 0;
					for (int index0 = 0; index0 < 36; index0++) {
						if ((new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									return _modHandler.getStackInSlot(sltid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) slot, entityiterator)).getItem() == EndlessEndModItems.TRANSPONDER.get() && ((new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									return _modHandler.getStackInSlot(sltid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) slot, entityiterator)).getDisplayName().getString()).equals(itemstack.getDisplayName().getString())) {
							found = true;
							if (entityiterator.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = newtransponder.copy();
								_setstack.setCount(1);
								_modHandler.setStackInSlot((int) slot, _setstack);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:transponder.transmission.on")),
											SoundSource.PLAYERS, 1, 1);
								} else {
									_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:transponder.transmission.on")),
											SoundSource.PLAYERS, 1, 1, false);
								}
							}
						}
						slot = slot + 1;
					}
				}
			}
			if (found == true) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:transponder.transmission.success")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:transponder.transmission.success")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:transponder.transmission.failure")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:transponder.transmission.failure")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		}
	}
}
