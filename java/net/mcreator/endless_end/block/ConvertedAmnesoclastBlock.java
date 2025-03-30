
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.AmnesicSpreadProcedure;
import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class ConvertedAmnesoclastBlock extends Block {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 12);

	public ConvertedAmnesoclastBlock() {
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
						return 0;
					}
				}.getLightLevel())).randomTicks());
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
	public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
		return new ItemStack(EndlessEndModBlocks.AMNESOCLAST.get());
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		AmnesicSpreadProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
