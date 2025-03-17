package net.mcreator.endless_end.procedures;

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

public class TransponderDeactivateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack newtransponder = ItemStack.EMPTY;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EndlessEndModItems.PULSING_TRANSPONDER.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EndlessEndModItems.SENDING_TRANSPONDER.get()) {
			newtransponder = new ItemStack(EndlessEndModItems.TRANSPONDER.get()).copy();
			newtransponder.set(DataComponents.CUSTOM_NAME, Component.literal((((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", ""))));
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = newtransponder.copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:transponder.transmission.off")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:transponder.transmission.off")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		}
	}
}
