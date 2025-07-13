package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModItems;
import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.entity.FlurryEntity;

public class FlurryDropProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		for (int index0 = 0; index0 < (int) (Mth.nextInt(RandomSource.create(), 0, 2) + Math.min(Mth.nextInt(RandomSource.create(), 1, 3),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)))); index0++) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EndlessEndModItems.FLURRY_ROD.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if ((world.getBlockState(BlockPos.containing(entity instanceof FlurryEntity _datEntI ? _datEntI.getEntityData().get(FlurryEntity.DATA_homeX) : 0,
				entity instanceof FlurryEntity _datEntI ? _datEntI.getEntityData().get(FlurryEntity.DATA_homeY) : 0, entity instanceof FlurryEntity _datEntI ? _datEntI.getEntityData().get(FlurryEntity.DATA_homeZ) : 0)))
				.getBlock() == EndlessEndModBlocks.FLOURITE.get()) {
			world.setBlock(BlockPos.containing(entity instanceof FlurryEntity _datEntI ? _datEntI.getEntityData().get(FlurryEntity.DATA_homeX) : 0, entity instanceof FlurryEntity _datEntI ? _datEntI.getEntityData().get(FlurryEntity.DATA_homeY) : 0,
					entity instanceof FlurryEntity _datEntI ? _datEntI.getEntityData().get(FlurryEntity.DATA_homeZ) : 0), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", 0)), 3);
		}
	}
}
