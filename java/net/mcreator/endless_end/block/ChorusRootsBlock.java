
package net.mcreator.endless_end.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class ChorusRootsBlock extends FlowerBlock {
	public ChorusRootsBlock() {
		super(MobEffects.MOVEMENT_SPEED, 100,
				BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.NETHER_SPROUTS).instabreak().speedFactor(0.9f).noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return box(2, 0, 2, 14, 12, 14);
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(EndlessEndModBlocks.CANTICLE.get()) || groundState.is(EndlessEndModBlocks.ROTTING_END_STONE.get()) || groundState.is(EndlessEndModBlocks.BLOOMING_CANTICLE.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}
}
