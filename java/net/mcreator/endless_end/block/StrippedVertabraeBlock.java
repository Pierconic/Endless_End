
package net.mcreator.endless_end.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class StrippedVertabraeBlock extends Block {
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

	public StrippedVertabraeBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).mapColor(MapColor.COLOR_BLACK)
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.coral_block.break")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_sensor.step")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.coral_block.place")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_sensor.hit")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_catalyst.fall"))))
				.strength(3f).requiresCorrectToolForDrops());
		this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(AXIS);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(AXIS, context.getClickedFace().getAxis());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
			if (state.getValue(AXIS) == Direction.Axis.X) {
				return state.setValue(AXIS, Direction.Axis.Z);
			} else if (state.getValue(AXIS) == Direction.Axis.Z) {
				return state.setValue(AXIS, Direction.Axis.X);
			}
		}
		return state;
	}
}
