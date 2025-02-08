package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModGameRules;
import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.EndlessEndMod;

public class InitiateFunctionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity(true);
		if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.FLAVORBLOCK.get())) {
			EndlessEndMod.queueServerWork(3, () -> {
				if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.FLAVORBLOCK.get())) {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			});
		}
		if (world.getLevelData().getGameRules().getBoolean(EndlessEndModGameRules.TICK_GENBLOCKS) && !(new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "Mechanical"))) {
			if (!entity.level().isClientSide())
				entity.discard();
			EndlessEndMod.queueServerWork((int) (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "DelayTime")), () -> {
				if (world.getLevelData().getGameRules().getBoolean(EndlessEndModGameRules.TICK_GENBLOCKS) && !(new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "Mechanical"))) {
					ProcessFlavorFunctionProcedure.execute(world, x, y, z);
					if (!(new Object() {
						public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getBoolean(tag);
							return false;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "Persistent"))) {
						{
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
						}
						world.setBlock(BlockPos.containing(x, y, z), BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world, BlockPos.containing(x, y, z), "TransformBlock"))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
					}
				}
			});
		}
	}
}
