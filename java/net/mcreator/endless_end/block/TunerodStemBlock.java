
package net.mcreator.endless_end.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
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
import net.minecraft.world.MenuProvider;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.TunerodNeighborBreakProcedure;
import net.mcreator.endless_end.procedures.TuneRodGrowthProcedure;
import net.mcreator.endless_end.block.entity.TunerodStemBlockEntity;

public class TunerodStemBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 11);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 20);

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
				if (s.getValue(BLOCKSTATE) == 11)
					return 0;
				return 0;
			}
		}.getLightLevel())).requiresCorrectToolForDrops().noOcclusion().randomTicks().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL).setValue(AGE, 0).setValue(WATERLOGGED, false));
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
					case FLOOR -> box(5.5, 0, 5.5, 10.5, 16, 10.5);
					case WALL -> box(5.5, 5.5, 0, 10.5, 10.5, 16);
					case CEILING -> box(5.5, 0, 5.5, 10.5, 16, 10.5);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(5.5, 0, 5.5, 10.5, 16, 10.5);
					case WALL -> box(5.5, 5.5, 0, 10.5, 10.5, 16);
					case CEILING -> box(5.5, 0, 5.5, 10.5, 16, 10.5);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(5.5, 0, 5.5, 10.5, 16, 10.5);
					case WALL -> box(0, 5.5, 5.5, 16, 10.5, 10.5);
					case CEILING -> box(5.5, 0, 5.5, 10.5, 16, 10.5);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(5.5, 0, 5.5, 10.5, 16, 10.5);
					case WALL -> box(0, 5.5, 5.5, 16, 10.5, 10.5);
					case CEILING -> box(5.5, 0, 5.5, 10.5, 16, 10.5);
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6, 0, 6, 10, 16, 10);
					case WALL -> box(6, 6, 0, 10, 10, 16);
					case CEILING -> box(6, 0, 6, 10, 16, 10);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6, 0, 6, 10, 16, 10);
					case WALL -> box(6, 6, 0, 10, 10, 16);
					case CEILING -> box(6, 0, 6, 10, 16, 10);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6, 0, 6, 10, 16, 10);
					case WALL -> box(0, 6, 6, 16, 10, 10);
					case CEILING -> box(6, 0, 6, 10, 16, 10);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6, 0, 6, 10, 16, 10);
					case WALL -> box(0, 6, 6, 16, 10, 10);
					case CEILING -> box(6, 0, 6, 10, 16, 10);
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6, 0, 6, 10, 16, 10);
					case WALL -> box(6, 6, 0, 10, 10, 16);
					case CEILING -> box(6, 0, 6, 10, 16, 10);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6, 0, 6, 10, 16, 10);
					case WALL -> box(6, 6, 0, 10, 10, 16);
					case CEILING -> box(6, 0, 6, 10, 16, 10);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6, 0, 6, 10, 16, 10);
					case WALL -> box(0, 6, 6, 16, 10, 10);
					case CEILING -> box(6, 0, 6, 10, 16, 10);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6, 0, 6, 10, 16, 10);
					case WALL -> box(0, 6, 6, 16, 10, 10);
					case CEILING -> box(6, 0, 6, 10, 16, 10);
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(6, 5, 6, 10, 16, 10), box(6, 1, 0, 10, 5, 10));
					case WALL -> Shapes.or(box(6, 6, 5, 10, 10, 16), box(6, 6, 1, 10, 16, 5));
					case CEILING -> Shapes.or(box(6, 0, 6, 10, 11, 10), box(6, 11, 0, 10, 15, 10));
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(6, 5, 6, 10, 16, 10), box(6, 1, 6, 10, 5, 16));
					case WALL -> Shapes.or(box(6, 6, 0, 10, 10, 11), box(6, 6, 11, 10, 16, 15));
					case CEILING -> Shapes.or(box(6, 0, 6, 10, 11, 10), box(6, 11, 6, 10, 15, 16));
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(6, 5, 6, 10, 16, 10), box(0, 1, 6, 10, 5, 10));
					case WALL -> Shapes.or(box(5, 6, 6, 16, 10, 10), box(1, 6, 6, 5, 16, 10));
					case CEILING -> Shapes.or(box(6, 0, 6, 10, 11, 10), box(0, 11, 6, 10, 15, 10));
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(6, 5, 6, 10, 16, 10), box(6, 1, 6, 16, 5, 10));
					case WALL -> Shapes.or(box(0, 6, 6, 11, 10, 10), box(11, 6, 6, 15, 16, 10));
					case CEILING -> Shapes.or(box(6, 0, 6, 10, 11, 10), box(6, 11, 6, 16, 15, 10));
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 5) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(5, 0, 5, 11, 6, 11);
					case WALL -> box(5, 5, 0, 11, 11, 6);
					case CEILING -> box(5, 10, 5, 11, 16, 11);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(5, 0, 5, 11, 6, 11);
					case WALL -> box(5, 5, 10, 11, 11, 16);
					case CEILING -> box(5, 10, 5, 11, 16, 11);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(5, 0, 5, 11, 6, 11);
					case WALL -> box(0, 5, 5, 6, 11, 11);
					case CEILING -> box(5, 10, 5, 11, 16, 11);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(5, 0, 5, 11, 6, 11);
					case WALL -> box(10, 5, 5, 16, 11, 11);
					case CEILING -> box(5, 10, 5, 11, 16, 11);
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 6) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(5, 0, 5, 11, 6, 11), box(0, 1, 6, 16, 5, 10));
					case WALL -> Shapes.or(box(5, 5, 0, 11, 11, 6), box(0, 6, 1, 16, 10, 5));
					case CEILING -> Shapes.or(box(5, 10, 5, 11, 16, 11), box(0, 11, 6, 16, 15, 10));
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(5, 0, 5, 11, 6, 11), box(0, 1, 6, 16, 5, 10));
					case WALL -> Shapes.or(box(5, 5, 10, 11, 11, 16), box(0, 6, 11, 16, 10, 15));
					case CEILING -> Shapes.or(box(5, 10, 5, 11, 16, 11), box(0, 11, 6, 16, 15, 10));
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(5, 0, 5, 11, 6, 11), box(6, 1, 0, 10, 5, 16));
					case WALL -> Shapes.or(box(0, 5, 5, 6, 11, 11), box(1, 6, 0, 5, 10, 16));
					case CEILING -> Shapes.or(box(5, 10, 5, 11, 16, 11), box(6, 11, 0, 10, 15, 16));
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(5, 0, 5, 11, 6, 11), box(6, 1, 0, 10, 5, 16));
					case WALL -> Shapes.or(box(10, 5, 5, 16, 11, 11), box(11, 6, 0, 15, 10, 16));
					case CEILING -> Shapes.or(box(5, 10, 5, 11, 16, 11), box(6, 11, 0, 10, 15, 16));
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 7) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
					case WALL -> box(6.5, 6.5, 0, 9.5, 9.5, 16);
					case CEILING -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
					case WALL -> box(6.5, 6.5, 0, 9.5, 9.5, 16);
					case CEILING -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
					case WALL -> box(0, 6.5, 6.5, 16, 9.5, 9.5);
					case CEILING -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
					case WALL -> box(0, 6.5, 6.5, 16, 9.5, 9.5);
					case CEILING -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 8) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
					case WALL -> box(6.5, 6.5, 0, 9.5, 9.5, 16);
					case CEILING -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
					case WALL -> box(6.5, 6.5, 0, 9.5, 9.5, 16);
					case CEILING -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
					case WALL -> box(0, 6.5, 6.5, 16, 9.5, 9.5);
					case CEILING -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
					case WALL -> box(0, 6.5, 6.5, 16, 9.5, 9.5);
					case CEILING -> box(6.5, 0, 6.5, 9.5, 16, 9.5);
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 9) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10));
					case WALL -> Shapes.or(box(6.5, 6.5, 0, 9.5, 9.5, 5), box(6, 6, 5, 10, 10, 9));
					case CEILING -> Shapes.or(box(6.5, 11, 6.5, 9.5, 16, 9.5), box(6, 7, 6, 10, 11, 10));
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10));
					case WALL -> Shapes.or(box(6.5, 6.5, 11, 9.5, 9.5, 16), box(6, 6, 7, 10, 10, 11));
					case CEILING -> Shapes.or(box(6.5, 11, 6.5, 9.5, 16, 9.5), box(6, 7, 6, 10, 11, 10));
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10));
					case WALL -> Shapes.or(box(0, 6.5, 6.5, 5, 9.5, 9.5), box(5, 6, 6, 9, 10, 10));
					case CEILING -> Shapes.or(box(6.5, 11, 6.5, 9.5, 16, 9.5), box(6, 7, 6, 10, 11, 10));
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10));
					case WALL -> Shapes.or(box(11, 6.5, 6.5, 16, 9.5, 9.5), box(7, 6, 6, 11, 10, 10));
					case CEILING -> Shapes.or(box(6.5, 11, 6.5, 9.5, 16, 9.5), box(6, 7, 6, 10, 11, 10));
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 10) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10), box(2.5, 6, 7, 13.5, 8, 9), box(11.5, 8, 7, 13.5, 19, 9), box(2.5, 8, 7, 4.5, 19, 9));
					case WALL -> Shapes.or(box(6.5, 6.5, 0, 9.5, 9.5, 5), box(6, 6, 5, 10, 10, 9), box(2.5, 7, 6, 13.5, 9, 8), box(11.5, 7, 8, 13.5, 9, 19), box(2.5, 7, 8, 4.5, 9, 19));
					case CEILING -> Shapes.or(box(6.5, 11, 6.5, 9.5, 16, 9.5), box(6, 7, 6, 10, 11, 10), box(2.5, 8, 7, 13.5, 10, 9), box(2.5, -3, 7, 4.5, 8, 9), box(11.5, -3, 7, 13.5, 8, 9));
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10), box(2.5, 6, 7, 13.5, 8, 9), box(2.5, 8, 7, 4.5, 19, 9), box(11.5, 8, 7, 13.5, 19, 9));
					case WALL -> Shapes.or(box(6.5, 6.5, 11, 9.5, 9.5, 16), box(6, 6, 7, 10, 10, 11), box(2.5, 7, 8, 13.5, 9, 10), box(2.5, 7, -3, 4.5, 9, 8), box(11.5, 7, -3, 13.5, 9, 8));
					case CEILING -> Shapes.or(box(6.5, 11, 6.5, 9.5, 16, 9.5), box(6, 7, 6, 10, 11, 10), box(2.5, 8, 7, 13.5, 10, 9), box(11.5, -3, 7, 13.5, 8, 9), box(2.5, -3, 7, 4.5, 8, 9));
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10), box(7, 6, 2.5, 9, 8, 13.5), box(7, 8, 2.5, 9, 19, 4.5), box(7, 8, 11.5, 9, 19, 13.5));
					case WALL -> Shapes.or(box(0, 6.5, 6.5, 5, 9.5, 9.5), box(5, 6, 6, 9, 10, 10), box(6, 7, 2.5, 8, 9, 13.5), box(8, 7, 2.5, 19, 9, 4.5), box(8, 7, 11.5, 19, 9, 13.5));
					case CEILING -> Shapes.or(box(6.5, 11, 6.5, 9.5, 16, 9.5), box(6, 7, 6, 10, 11, 10), box(7, 8, 2.5, 9, 10, 13.5), box(7, -3, 11.5, 9, 8, 13.5), box(7, -3, 2.5, 9, 8, 4.5));
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> Shapes.or(box(6.5, 0, 6.5, 9.5, 5, 9.5), box(6, 5, 6, 10, 9, 10), box(7, 6, 2.5, 9, 8, 13.5), box(7, 8, 11.5, 9, 19, 13.5), box(7, 8, 2.5, 9, 19, 4.5));
					case WALL -> Shapes.or(box(11, 6.5, 6.5, 16, 9.5, 9.5), box(7, 6, 6, 11, 10, 10), box(8, 7, 2.5, 10, 9, 13.5), box(-3, 7, 11.5, 8, 9, 13.5), box(-3, 7, 2.5, 8, 9, 4.5));
					case CEILING -> Shapes.or(box(6.5, 11, 6.5, 9.5, 16, 9.5), box(6, 7, 6, 10, 11, 10), box(7, 8, 2.5, 9, 10, 13.5), box(7, -3, 2.5, 9, 8, 4.5), box(7, -3, 11.5, 9, 8, 13.5));
				};
			};
		}
		if (state.getValue(BLOCKSTATE) == 11) {
			return switch (state.getValue(FACING)) {
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> box(5, 0, 5, 11, 16, 11);
					case WALL -> box(5, 5, 0, 11, 11, 16);
					case CEILING -> box(5, 0, 5, 11, 16, 11);
				};
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> box(5, 0, 5, 11, 16, 11);
					case WALL -> box(5, 5, 0, 11, 11, 16);
					case CEILING -> box(5, 0, 5, 11, 16, 11);
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(5, 0, 5, 11, 16, 11);
					case WALL -> box(0, 5, 5, 16, 11, 11);
					case CEILING -> box(5, 0, 5, 11, 16, 11);
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> box(5, 0, 5, 11, 16, 11);
					case WALL -> box(0, 5, 5, 16, 11, 11);
					case CEILING -> box(5, 0, 5, 11, 16, 11);
				};
			};
		}
		return switch (state.getValue(FACING)) {
			default -> switch (state.getValue(FACE)) {
				case FLOOR -> box(5, 0, 5, 11, 12, 11);
				case WALL -> box(5, 5, 0, 11, 11, 12);
				case CEILING -> box(5, 4, 5, 11, 16, 11);
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> box(5, 0, 5, 11, 12, 11);
				case WALL -> box(5, 5, 4, 11, 11, 16);
				case CEILING -> box(5, 4, 5, 11, 16, 11);
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> box(5, 0, 5, 11, 12, 11);
				case WALL -> box(0, 5, 5, 12, 11, 11);
				case CEILING -> box(5, 4, 5, 11, 16, 11);
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> box(5, 0, 5, 11, 12, 11);
				case WALL -> box(4, 5, 5, 16, 11, 11);
				case CEILING -> box(5, 4, 5, 11, 16, 11);
			};
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, FACE, AGE, WATERLOGGED, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return super.getStateForPlacement(context).setValue(FACE, faceForDirection(context.getNearestLookingDirection())).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(AGE, 0).setValue(WATERLOGGED, flag);
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
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		TunerodNeighborBreakProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		TuneRodGrowthProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
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
