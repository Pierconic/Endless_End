package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class RemnantPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double randy = 0;
		double xoff = 0;
		double yoff = 0;
		double zoff = 0;
		xoff = 0;
		yoff = 0;
		zoff = 0;
		randy = Mth.nextInt(RandomSource.create(), 1, 17);
		if (randy == 1) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_1"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 2) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_2"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 3) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_3"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 4) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_4"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 5) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_5"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 6) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_6"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 7) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_7"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 8) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_8"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 9) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_9"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 10) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_10"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 11) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_11"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 12) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_12"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 13) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_13"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 14) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_14"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 15) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_15"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 16) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_16"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_17"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		}
	}
}
