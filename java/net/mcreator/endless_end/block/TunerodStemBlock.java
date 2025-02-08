
package net.mcreator.endless_end.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.MenuProvider;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.TunerodNeighborBreakProcedure;
import net.mcreator.endless_end.procedures.TuneRodGrowthProcedure;
import net.mcreator.endless_end.block.entity.TunerodStemBlockEntity;

public class TunerodStemBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 10);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public TunerodStemBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BAMBOO_WOOD).strength(1f, 2f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				if (s.getValue(BLOCKSTATE) == 4)
					return 0;
				if (s.getValue(BLOCKSTATE) == 5)
					return 0;
				if (s.getValue(BLOCKSTATE) == 6)
					return 0;
				if (s.getValue(BLOCKSTATE) == 7)
					return 0;
				if (s.getValue(BLOCKSTATE) == 8)
					return 0;
				if (s.getValue(BLOCKSTATE) == 9)
					return 0;
				if (s.getValue(BLOCKSTATE) == 10)
					return 0;
				return 0;
			}
		}.getLightLevel())).requiresCorrectToolForDrops().noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidstate) {
		return true;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
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
		if (state.getValue(BLOCKSTATE) == 1) {
			return switch (state.getValue(FACING)) {
				default -> box(5.5, 0, 5.5, 10.5, 16, 10.5);
				case NORTH -> box(5.5, 0, 5.5, 10.5, 16, 10.5);
				case EAST -> box(5.5, 0, 5.5, 10.5, 16, 10.5);
				case WEST -> box(5.5, 0, 5.5, 10.5, 16, 10.5);
			};
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
				default -> box(6, 0, 6, 10, 16, 10);
				case NORTH -> box(6, 0, 6, 10, 16, 10);
				case EAST -> box(6, 0, 6, 10, 16, 10);
				case WEST -> box(6, 0, 6, 10, 16, 10);
			};
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
				default -> box(6, 0, 6, 10, 16, 10);
				case NORTH -> box(6, 0, 6, 10, 16, 10);
				case EAST -> box(6, 0, 6, 10, 16, 10);
				case WEST -> box(6, 0, 6, 10, 16, 10);
			};
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6, 5, 6, 10, 16, 10), box(6, 1, 0, 10, 5, 10));
				case NORTH -> Shapes.or(box(6, 5, 6, 10, 16, 10), box(6, 1, 6, 10, 5, 16));
				case EAST -> Shapes.or(box(6, 5, 6, 10, 16, 10), box(0, 1, 6, 10, 5, 10));
				case WEST -> Shapes.or(box(6, 5, 6, 10, 16, 10), box(6, 1, 6, 16, 5, 10));
			};
		}
		if (state.getValue(BLOCKSTATE) == 5) {
			return switch (state.getValue(FACING)) {
				default -> box(5, 0, 5, 11, 6, 11);
				case NORTH -> box(5, 0, 5, 11, 6, 11);
				case EAST -> box(5, 0, 5, 11, 6, 11);
				case WEST -> box(5, 0, 5, 11, 6, 11);
			};
		}
		if (state.getValue(BLOCKSTATE) == 6) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(5, 0, 5, 11, 6, 11), box(0, 1, 6, 16, 5, 10));
				case NORTH -> Shapes.or(box(5, 0, 5, 11, 6, 11), box(0, 1, 6, 16, 5, 10));
				case EAST -> Shapes.or(box(5, 0, 5, 11, 6, 11), box(6, 1, 0, 10, 5, 16));
				case WEST -> Shapes.or(box(5, 0, 5, 11, 6, 11), box(6, 1, 0, 10, 5, 16));
			};
		}
		if (state.getValue(BLOCKSTATE) == 7) {
			return switch (state.getValue(FACING)) {
				default -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				case NORTH -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				case EAST -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				case WEST -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
			};
		}
		if (state.getValue(BLOCKSTATE) == 8) {
			return switch (state.getValue(FACING)) {
				default -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				case NORTH -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				case EAST -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				case WEST -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
			};
		}
		if (state.getValue(BLOCKSTATE) == 9) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10));
				case NORTH -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10));
				case EAST -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10));
				case WEST -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10));
			};
		}
		if (state.getValue(BLOCKSTATE) == 10) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10), box(2.5, 6, 7, 13.5, 8, 9), box(11.5, 8, 7, 13.5, 19, 9), box(2.5, 8, 7, 4.5, 19, 9));
				case NORTH -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10), box(2.5, 6, 7, 13.5, 8, 9), box(2.5, 8, 7, 4.5, 19, 9), box(11.5, 8, 7, 13.5, 19, 9));
				case EAST -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10), box(7, 6, 2.5, 9, 8, 13.5), box(7, 8, 2.5, 9, 19, 4.5), box(7, 8, 11.5, 9, 19, 13.5));
				case WEST -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10), box(7, 6, 2.5, 9, 8, 13.5), box(7, 8, 11.5, 9, 19, 13.5), box(7, 8, 2.5, 9, 19, 4.5));
			};
		}
		return switch (state.getValue(FACING)) {
			default -> box(5, 0, 5, 11, 16, 11);
			case NORTH -> box(5, 0, 5, 11, 16, 11);
			case EAST -> box(5, 0, 5, 11, 16, 11);
			case WEST -> box(5, 0, 5, 11, 16, 11);
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, WATERLOGGED, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		TunerodNeighborBreakProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		TuneRodGrowthProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new TunerodStemBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}
}
