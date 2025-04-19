
package net.mcreator.endless_end.block;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.IconoclastTransmitProcedure;
import net.mcreator.endless_end.block.entity.IconoclastBlockEntity;

public class IconoclastBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 63);

	public IconoclastBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM)
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.break")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.step")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.place")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.dig")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.step"))))
				.strength(6f, 7f).lightLevel(s -> (new Object() {
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
						if (s.getValue(BLOCKSTATE) == 12)
							return 0;
						if (s.getValue(BLOCKSTATE) == 13)
							return 0;
						if (s.getValue(BLOCKSTATE) == 14)
							return 0;
						if (s.getValue(BLOCKSTATE) == 15)
							return 0;
						if (s.getValue(BLOCKSTATE) == 16)
							return 0;
						if (s.getValue(BLOCKSTATE) == 17)
							return 0;
						if (s.getValue(BLOCKSTATE) == 18)
							return 0;
						if (s.getValue(BLOCKSTATE) == 19)
							return 0;
						if (s.getValue(BLOCKSTATE) == 20)
							return 0;
						if (s.getValue(BLOCKSTATE) == 21)
							return 0;
						if (s.getValue(BLOCKSTATE) == 22)
							return 0;
						if (s.getValue(BLOCKSTATE) == 23)
							return 0;
						if (s.getValue(BLOCKSTATE) == 24)
							return 0;
						if (s.getValue(BLOCKSTATE) == 25)
							return 0;
						if (s.getValue(BLOCKSTATE) == 26)
							return 0;
						if (s.getValue(BLOCKSTATE) == 27)
							return 0;
						if (s.getValue(BLOCKSTATE) == 28)
							return 0;
						if (s.getValue(BLOCKSTATE) == 29)
							return 0;
						if (s.getValue(BLOCKSTATE) == 30)
							return 0;
						if (s.getValue(BLOCKSTATE) == 31)
							return 0;
						if (s.getValue(BLOCKSTATE) == 32)
							return 0;
						if (s.getValue(BLOCKSTATE) == 33)
							return 0;
						if (s.getValue(BLOCKSTATE) == 34)
							return 0;
						if (s.getValue(BLOCKSTATE) == 35)
							return 0;
						if (s.getValue(BLOCKSTATE) == 36)
							return 0;
						if (s.getValue(BLOCKSTATE) == 37)
							return 0;
						if (s.getValue(BLOCKSTATE) == 38)
							return 0;
						if (s.getValue(BLOCKSTATE) == 39)
							return 0;
						if (s.getValue(BLOCKSTATE) == 40)
							return 0;
						if (s.getValue(BLOCKSTATE) == 41)
							return 0;
						if (s.getValue(BLOCKSTATE) == 42)
							return 0;
						if (s.getValue(BLOCKSTATE) == 43)
							return 0;
						if (s.getValue(BLOCKSTATE) == 44)
							return 0;
						if (s.getValue(BLOCKSTATE) == 45)
							return 0;
						if (s.getValue(BLOCKSTATE) == 46)
							return 0;
						if (s.getValue(BLOCKSTATE) == 47)
							return 0;
						if (s.getValue(BLOCKSTATE) == 48)
							return 0;
						if (s.getValue(BLOCKSTATE) == 49)
							return 0;
						if (s.getValue(BLOCKSTATE) == 50)
							return 0;
						if (s.getValue(BLOCKSTATE) == 51)
							return 0;
						if (s.getValue(BLOCKSTATE) == 52)
							return 0;
						if (s.getValue(BLOCKSTATE) == 53)
							return 0;
						if (s.getValue(BLOCKSTATE) == 54)
							return 0;
						if (s.getValue(BLOCKSTATE) == 55)
							return 0;
						if (s.getValue(BLOCKSTATE) == 56)
							return 0;
						if (s.getValue(BLOCKSTATE) == 57)
							return 0;
						if (s.getValue(BLOCKSTATE) == 58)
							return 0;
						if (s.getValue(BLOCKSTATE) == 59)
							return 0;
						if (s.getValue(BLOCKSTATE) == 60)
							return 0;
						if (s.getValue(BLOCKSTATE) == 61)
							return 0;
						if (s.getValue(BLOCKSTATE) == 62)
							return 0;
						if (s.getValue(BLOCKSTATE) == 63)
							return 0;
						return 0;
					}
				}.getLightLevel())));
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
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		IconoclastTransmitProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new IconoclastBlockEntity(pos, state);
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
			if (blockEntity instanceof IconoclastBlockEntity be) {
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
		if (tileentity instanceof IconoclastBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
