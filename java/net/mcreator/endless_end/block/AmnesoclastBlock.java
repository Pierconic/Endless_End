
package net.mcreator.endless_end.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.AmnesicSpreadProcedure;

public class AmnesoclastBlock extends Block {
	public AmnesoclastBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM)
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.break")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.step")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.place")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.dig")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:block.amnesoclast.step"))))
				.strength(6f, 7f).randomTicks());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		AmnesicSpreadProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
