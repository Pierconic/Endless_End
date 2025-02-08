
package net.mcreator.endless_end.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.IconoclastTransmissionProcedure;
import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class DormantIconoclastBlock extends Block {
	public DormantIconoclastBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM)
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:silence")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.step")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.place")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.dig")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.step"))))
				.strength(6f, 7f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
		return new ItemStack(EndlessEndModBlocks.ICONOCLAST.get());
	}

	@Override
	public void attack(BlockState blockstate, Level world, BlockPos pos, Player entity) {
		super.attack(blockstate, world, pos, entity);
		IconoclastTransmissionProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		IconoclastTransmissionProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}
}
