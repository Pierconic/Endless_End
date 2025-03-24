
package net.mcreator.endless_end.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.endless_end.procedures.RefusePatchFeatureProcedure;

public class EndWasteRefuseFeature extends SimpleBlockFeature {
	public EndWasteRefuseFeature() {
		super(SimpleBlockConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!RefusePatchFeatureProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}
