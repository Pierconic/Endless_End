
package net.mcreator.endless_end.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.LydianPetalsClickProcedure;
import net.mcreator.endless_end.procedures.LydianDropProcedure;
import net.mcreator.endless_end.procedures.LydianBreakageProcedure;

public class LydianPetalsBlock extends Block {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 3);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;

	public LydianPetalsBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.PINK_PETALS).strength(0.2f, 0.1f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 2;
				if (s.getValue(BLOCKSTATE) == 2)
					return 3;
				if (s.getValue(BLOCKSTATE) == 3)
					return 4;
				return 1;
			}
		}.getLightLevel())).noCollission().jumpFactor(1.2f).noOcclusion().pushReaction(PushReaction.DESTROY).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL));
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
		if (state.getValue(BLOCKSTATE) == 1) {
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

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, FACE, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		if (context.getClickedFace().getAxis() == Direction.Axis.Y)
			return super.getStateForPlacement(context).setValue(FACE, context.getClickedFace().getOpposite() == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).setValue(FACING, context.getHorizontalDirection());
		return super.getStateForPlacement(context).setValue(FACE, AttachFace.WALL).setValue(FACING, context.getClickedFace());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.OPEN;
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		LydianBreakageProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		LydianDropProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
		return retval;
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
		LydianPetalsClickProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}
}
