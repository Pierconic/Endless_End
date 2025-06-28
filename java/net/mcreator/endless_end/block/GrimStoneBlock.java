
package net.mcreator.endless_end.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class GrimStoneBlock extends Block {
	public GrimStoneBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BASALT).strength(3f, 8f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
