
package net.mcreator.endless_end.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.FlouriteLampRedstoneProcedure;

public class FlouriteLampBlock extends Block {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 15);

	public FlouriteLampBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST).strength(3f, 4f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 4;
				if (s.getValue(BLOCKSTATE) == 2)
					return 4;
				if (s.getValue(BLOCKSTATE) == 3)
					return 4;
				if (s.getValue(BLOCKSTATE) == 4)
					return 4;
				if (s.getValue(BLOCKSTATE) == 5)
					return 4;
				if (s.getValue(BLOCKSTATE) == 6)
					return 4;
				if (s.getValue(BLOCKSTATE) == 7)
					return 4;
				if (s.getValue(BLOCKSTATE) == 8)
					return 4;
				if (s.getValue(BLOCKSTATE) == 9)
					return 4;
				if (s.getValue(BLOCKSTATE) == 10)
					return 4;
				if (s.getValue(BLOCKSTATE) == 11)
					return 4;
				if (s.getValue(BLOCKSTATE) == 12)
					return 4;
				if (s.getValue(BLOCKSTATE) == 13)
					return 3;
				if (s.getValue(BLOCKSTATE) == 14)
					return 2;
				if (s.getValue(BLOCKSTATE) == 15)
					return 1;
				return 0;
			}
		}.getLightLevel())).requiresCorrectToolForDrops().friction(0.72f).speedFactor(1.2f).randomTicks().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return box(0, 0, 0, 16, 16, 16);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(BLOCKSTATE);
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		if (world.getBestNeighborSignal(pos) > 0) {
			FlouriteLampRedstoneProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		}
	}
}
