
package net.mcreator.endless_end.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.SculkTeethTickProcedure;
import net.mcreator.endless_end.procedures.SculkTeethCollisionProcedure;
import net.mcreator.endless_end.block.entity.SculkTeethBlockEntity;

public class SculkTeethBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 3);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public SculkTeethBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.SCULK_CATALYST).strength(0.3f, 0.2f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				return 0;
			}
		}.getLightLevel())).noCollission().speedFactor(0.7f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL).setValue(WATERLOGGED, false));
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
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(0, 0, 0, 16, 4, 16);
					case WALL -> box(0, 0, 0, 16, 16, 4);
					case CEILING -> box(0, 12, 0, 16, 16, 16);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(0, 0, 0, 16, 4, 16);
					case WALL -> box(0, 0, 12, 16, 16, 16);
					case CEILING -> box(0, 12, 0, 16, 16, 16);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(0, 0, 0, 16, 4, 16);
					case WALL -> box(0, 0, 0, 4, 16, 16);
					case CEILING -> box(0, 12, 0, 16, 16, 16);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(0, 0, 0, 16, 4, 16);
					case WALL -> box(12, 0, 0, 16, 16, 16);
					case CEILING -> box(0, 12, 0, 16, 16, 16);
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(0, 0, 0, 16, 6, 16);
					case WALL -> box(0, 0, 0, 16, 16, 6);
					case CEILING -> box(0, 10, 0, 16, 16, 16);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(0, 0, 0, 16, 6, 16);
					case WALL -> box(0, 0, 10, 16, 16, 16);
					case CEILING -> box(0, 10, 0, 16, 16, 16);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(0, 0, 0, 16, 6, 16);
					case WALL -> box(0, 0, 0, 6, 16, 16);
					case CEILING -> box(0, 10, 0, 16, 16, 16);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(0, 0, 0, 16, 6, 16);
					case WALL -> box(10, 0, 0, 16, 16, 16);
					case CEILING -> box(0, 10, 0, 16, 16, 16);
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(0, 0, 0, 16, 9, 16);
					case WALL -> box(0, 0, 0, 16, 16, 9);
					case CEILING -> box(0, 7, 0, 16, 16, 16);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(0, 0, 0, 16, 9, 16);
					case WALL -> box(0, 0, 7, 16, 16, 16);
					case CEILING -> box(0, 7, 0, 16, 16, 16);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(0, 0, 0, 16, 9, 16);
					case WALL -> box(0, 0, 0, 9, 16, 16);
					case CEILING -> box(0, 7, 0, 16, 16, 16);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(0, 0, 0, 16, 9, 16);
					case WALL -> box(7, 0, 0, 16, 16, 16);
					case CEILING -> box(0, 7, 0, 16, 16, 16);
				};
			};
		}
		return switch (state.getValue(FACING)) {
			default -> switch (state.getValue(FACE)) {
				case FLOOR -> box(0, 0, 0, 16, 3, 16);
				case WALL -> box(0, 0, 0, 16, 16, 3);
				case CEILING -> box(0, 13, 0, 16, 16, 16);
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> box(0, 0, 0, 16, 3, 16);
				case WALL -> box(0, 0, 13, 16, 16, 16);
				case CEILING -> box(0, 13, 0, 16, 16, 16);
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> box(0, 0, 0, 16, 3, 16);
				case WALL -> box(0, 0, 0, 3, 16, 16);
				case CEILING -> box(0, 13, 0, 16, 16, 16);
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> box(0, 0, 0, 16, 3, 16);
				case WALL -> box(13, 0, 0, 16, 16, 16);
				case CEILING -> box(0, 13, 0, 16, 16, 16);
			};
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, FACE, WATERLOGGED, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return super.getStateForPlacement(context).setValue(FACE, faceForDirection(context.getNearestLookingDirection())).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	private AttachFace faceForDirection(Direction direction) {
		if (direction.getAxis() == Direction.Axis.Y)
			return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
		else
			return AttachFace.WALL;
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
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 2);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		SculkTeethTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		world.scheduleTick(pos, this, 2);
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		SculkTeethCollisionProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new SculkTeethBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof SculkTeethBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof SculkTeethBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
