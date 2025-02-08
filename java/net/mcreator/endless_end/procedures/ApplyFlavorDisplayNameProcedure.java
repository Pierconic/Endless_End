package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class ApplyFlavorDisplayNameProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState transfered_block = Blocks.AIR.defaultBlockState();
		ItemStack returned_item = ItemStack.EMPTY;
		transfered_block = (world.getBlockState(BlockPos.containing(x, y, z)));
		returned_item = (new ItemStack(transfered_block.getBlock()));
		returned_item.set(DataComponents.CUSTOM_NAME, Component.literal((new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "SecretName"))));
		{
			final String _tagName = "DelayTime";
			final double _tagValue = (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "DelayTime"));
			CustomData.update(DataComponents.CUSTOM_DATA, returned_item, tag -> tag.putDouble(_tagName, _tagValue));
		}
		{
			final String _tagName = "StoredFunction";
			final String _tagValue = (new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "StoredFunction"));
			CustomData.update(DataComponents.CUSTOM_DATA, returned_item, tag -> tag.putString(_tagName, _tagValue));
		}
		{
			final String _tagName = "TransformBlock";
			final String _tagValue = (new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "TransformBlock"));
			CustomData.update(DataComponents.CUSTOM_DATA, returned_item, tag -> tag.putString(_tagName, _tagValue));
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = returned_item.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}
