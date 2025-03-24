
package net.mcreator.endless_end.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.RefuseSnapProcedure;

import com.mojang.serialization.MapCodec;

public class RefuseBlock extends FallingBlock {
	public static final MapCodec<RefuseBlock> CODEC = simpleCodec(properties -> new RefuseBlock());

	public MapCodec<RefuseBlock> codec() {
		return CODEC;
	}

	public RefuseBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.SAND)
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.suspicious_gravel.break")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:refuse_step")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.suspicious_gravel.break")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:refuse_hit")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:refuse_snap"))))
				.strength(6f, 7f).requiresCorrectToolForDrops().speedFactor(0.8f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		RefuseSnapProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}
