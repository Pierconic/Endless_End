
package net.mcreator.endless_end.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.NoOpFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.endless_end.procedures.SculkPitfallsProcedure;

public class PitfallPlacementFeature extends NoOpFeature {
	public PitfallPlacementFeature() {
		super(NoneFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!SculkPitfallsProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}
