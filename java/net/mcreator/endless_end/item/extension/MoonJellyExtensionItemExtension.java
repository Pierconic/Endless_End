
package net.mcreator.endless_end.item.extension;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.Direction;

import net.mcreator.endless_end.procedures.MoonJellyDispenseProcedure;
import net.mcreator.endless_end.procedures.MoonJellyDispenseCheckProcedure;
import net.mcreator.endless_end.init.EndlessEndModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MoonJellyExtensionItemExtension {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> DispenserBlock.registerBehavior(EndlessEndModItems.MOON_JELLY.get(), new OptionalDispenseItemBehavior() {
			public ItemStack execute(BlockSource blockSource, ItemStack stack) {
				ItemStack itemstack = stack.copy();
				Level world = blockSource.level();
				Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
				int x = blockSource.pos().getX();
				int y = blockSource.pos().getY();
				int z = blockSource.pos().getZ();
				this.setSuccess(MoonJellyDispenseCheckProcedure.execute(world, x, y, z, direction));
				boolean success = this.isSuccess();
				MoonJellyDispenseProcedure.execute(world, x, y, z, direction);
				if (success)
					itemstack.shrink(1);
				return itemstack;
			}
		}));
	}
}
