package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.EndlessEndMod;

public class BreezeSpellPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, boolean noisy) {
		BlockState savedBlock = Blocks.AIR.defaultBlockState();
		if (world.getBlockFloorHeight(BlockPos.containing(x, y, z)) > 0 && !(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:spell_immune")))) {
			savedBlock = (world.getBlockState(BlockPos.containing(x, y, z)));
			world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.BREEZE_SPELL.get().defaultBlockState(), 3);
			if (noisy) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("noisy", true);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
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
