package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.EndlessEndMod;

public class BlazeSpellPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState savedBlock = Blocks.AIR.defaultBlockState();
		if (world.getBlockFloorHeight(BlockPos.containing(x, y, z)) > 0 && !(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:spell_immune")))) {
			savedBlock = (world.getBlockState(BlockPos.containing(x, y, z)));
			world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.BLAZE_SPELL.get().defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.basalt.hit")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.basalt.hit")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = (new ItemStack(savedBlock.getBlock())).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(0, _setstack);
			}
		}
		EndlessEndMod.queueServerWork(4, () -> {
			SpellNotifyProcedure.execute(world, x, y, z);
		});
	}
}
