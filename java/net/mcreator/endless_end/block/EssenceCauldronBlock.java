
package net.mcreator.endless_end.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.EssenceCauldronDamageProcedure;

public class EssenceCauldronBlock extends Block {
	public EssenceCauldronBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(2f).lightLevel(s -> 12).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidstate) {
		return true;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.or(box(0, 3, 0, 2, 16, 16), box(2, 3, 2, 14, 4, 14), box(14, 3, 0, 16, 16, 16), box(2, 3, 0, 14, 16, 2), box(2, 3, 14, 14, 16, 16), box(0, 0, 0, 4, 3, 2), box(0, 0, 2, 2, 3, 4), box(12, 0, 0, 16, 3, 2), box(14, 0, 2, 16, 3, 4),
				box(0, 0, 14, 4, 3, 16), box(0, 0, 12, 2, 3, 14), box(12, 0, 14, 16, 3, 16), box(14, 0, 12, 16, 3, 14));
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		EssenceCauldronDamageProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}
