
package net.mcreator.endless_end.block;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.InfestedGrimstoneBurstProcedure;

public class InfestedGrimStoneBlock extends Block {
	public InfestedGrimStoneBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BASALT).strength(0.2f, 8f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		InfestedGrimstoneBurstProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}
}
