package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class SmolPillarPlacementProcedure {
	public static void execute(LevelAccessor world, double x, double z) {
		boolean top_found = false;
		double sy = 0;
		double y_off = 0;
		sy = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) - 7;
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "small_pillar_base_1"));
			if (template != null) {
				template.placeInWorld(_serverworld, BlockPos.containing(x - 1, sy, z - 1), BlockPos.containing(x - 1, sy, z - 1), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
						_serverworld.random, 3);
			}
		}
		sy = sy + 16;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 3, 5); index0++) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "small_pillar_segment_1"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x, sy, z), BlockPos.containing(x, sy, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			sy = sy + 8;
		}
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "small_pillar_topper_1"));
			if (template != null) {
				template.placeInWorld(_serverworld, BlockPos.containing(x, sy, z), BlockPos.containing(x, sy, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
			}
		}
	}
}
