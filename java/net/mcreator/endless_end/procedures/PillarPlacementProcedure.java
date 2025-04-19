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

public class PillarPlacementProcedure {
	public static void execute(LevelAccessor world, double x, double z, double type) {
		boolean top_found = false;
		double sy = 0;
		double y_off = 0;
		double rando = 0;
		sy = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) - 7;
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "large_pillar_base_1"));
			if (template != null) {
				template.placeInWorld(_serverworld, BlockPos.containing(x - 1, sy, z - 1), BlockPos.containing(x - 1, sy, z - 1), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
						_serverworld.random, 3);
			}
		}
		sy = sy + 16;
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 4); index0++) {
			rando = Mth.nextInt(RandomSource.create(), 1, 6);
			if (rando == 1) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "large_pillar_segment_1"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x, sy, z), BlockPos.containing(x, sy, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
								3);
					}
				}
			} else if (rando == 2) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "large_pillar_segment_2"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x, sy, z), BlockPos.containing(x, sy, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
								3);
					}
				}
			} else if (rando == 3) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "large_pillar_segment_3"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x, sy, z), BlockPos.containing(x, sy, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
								3);
					}
				}
			} else if (rando == 4) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "large_pillar_segment_4"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x, sy, z), BlockPos.containing(x, sy, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
								3);
					}
				}
			} else if (rando == 5) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "large_pillar_segment_5"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x, sy, z), BlockPos.containing(x, sy, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
								3);
					}
				}
			} else if (rando == 6) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "large_pillar_segment_6"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x, sy, z), BlockPos.containing(x, sy, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random,
								3);
					}
				}
			}
			sy = sy + 9;
		}
		if (type == 2) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "large_pillar_topper_3"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x, sy, z), BlockPos.containing(x, sy, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (type == 1) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "large_pillar_topper_2"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x, sy, z), BlockPos.containing(x, sy, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "large_pillar_topper_1"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x, sy, z), BlockPos.containing(x, sy, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		}
	}
}
