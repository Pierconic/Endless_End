
package net.mcreator.endless_end.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.StrangeEggsShotProcedure;
import net.mcreator.endless_end.procedures.StrangeEggsNeighborProcedure;
import net.mcreator.endless_end.procedures.StrangeEggsAgeProcedure;
import net.mcreator.endless_end.procedures.StrangeEggWalkProcedure;
import net.mcreator.endless_end.procedures.PlayerStrangeEggsBreakProcedure;

public class StrangeEggsBlock extends Block implements SimpleWaterloggedBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 15);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public StrangeEggsBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.CORAL_BLOCK).strength(0.3f, 0f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 5;
				if (s.getValue(BLOCKSTATE) == 2)
					return 7;
				if (s.getValue(BLOCKSTATE) == 3)
					return 9;
				if (s.getValue(BLOCKSTATE) == 4)
					return 3;
				if (s.getValue(BLOCKSTATE) == 5)
					return 5;
				if (s.getValue(BLOCKSTATE) == 6)
					return 7;
				if (s.getValue(BLOCKSTATE) == 7)
					return 9;
				if (s.getValue(BLOCKSTATE) == 8)
					return 3;
				if (s.getValue(BLOCKSTATE) == 9)
					return 5;
				if (s.getValue(BLOCKSTATE) == 10)
					return 7;
				if (s.getValue(BLOCKSTATE) == 11)
					return 9;
				if (s.getValue(BLOCKSTATE) == 12)
					return 0;
				if (s.getValue(BLOCKSTATE) == 13)
					return 0;
				if (s.getValue(BLOCKSTATE) == 14)
					return 0;
				if (s.getValue(BLOCKSTATE) == 15)
					return 0;
				return 3;
			}
		}.getLightLevel())).noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL).setValue(WATERLOGGED, false));
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
		if (state.getValue(BLOCKSTATE) == 12) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(1, 1, 0, 15, 15, 4);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(1, 1, 12, 15, 15, 16);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(0, 1, 1, 4, 15, 15);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(12, 1, 1, 16, 15, 15);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 13) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(1, 1, 0, 15, 15, 4);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(1, 1, 12, 15, 15, 16);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(0, 1, 1, 4, 15, 15);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(12, 1, 1, 16, 15, 15);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 14) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(1, 1, 0, 15, 15, 4);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(1, 1, 12, 15, 15, 16);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(0, 1, 1, 4, 15, 15);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(12, 1, 1, 16, 15, 15);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 15) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(1, 1, 0, 15, 15, 4);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(1, 1, 12, 15, 15, 16);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(0, 1, 1, 4, 15, 15);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(1, 0, 1, 15, 4, 15);
					case WALL -> box(12, 1, 1, 16, 15, 15);
					case CEILING -> box(1, 12, 1, 15, 16, 15);
				};
			};
		}
		return switch (state.getValue(FACING)) {
			default -> switch (state.getValue(FACE)) {
				case FLOOR -> box(1, 0, 1, 15, 9, 15);
				case WALL -> box(1, 1, 0, 15, 15, 9);
				case CEILING -> box(1, 7, 1, 15, 16, 15);
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> box(1, 0, 1, 15, 9, 15);
				case WALL -> box(1, 1, 7, 15, 15, 16);
				case CEILING -> box(1, 7, 1, 15, 16, 15);
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> box(1, 0, 1, 15, 9, 15);
				case WALL -> box(0, 1, 1, 9, 15, 15);
				case CEILING -> box(1, 7, 1, 15, 16, 15);
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> box(1, 0, 1, 15, 9, 15);
				case WALL -> box(7, 1, 1, 16, 15, 15);
				case CEILING -> box(1, 7, 1, 15, 16, 15);
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
		if (context.getClickedFace().getAxis() == Direction.Axis.Y)
			return super.getStateForPlacement(context).setValue(FACE, context.getClickedFace().getOpposite() == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).setValue(FACING, context.getHorizontalDirection()).setValue(WATERLOGGED, flag);
		return super.getStateForPlacement(context).setValue(FACE, AttachFace.WALL).setValue(FACING, context.getClickedFace()).setValue(WATERLOGGED, flag);
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
		StrangeEggsNeighborProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		StrangeEggsAgeProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		PlayerStrangeEggsBreakProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
		return retval;
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		StrangeEggWalkProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}

	@Override
	public void onProjectileHit(Level world, BlockState blockstate, BlockHitResult hit, Projectile entity) {
		StrangeEggsShotProcedure.execute(world, hit.getBlockPos().getX(), hit.getBlockPos().getY(), hit.getBlockPos().getZ(), blockstate);
	}
}
