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

public class BigRemnantPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double randy = 0;
		double xoff = 0;
		double yoff = 0;
		double zoff = 0;
		xoff = 0;
		yoff = 0;
		zoff = 0;
		randy = Mth.nextInt(RandomSource.create(), 18, 40);
		if (randy == 18) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_18"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 19) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_19"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 20) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_20"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 21) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_21"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 22) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_22"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 23) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_23"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 24) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_24"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 25) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_25"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 26) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_26"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 27) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_27"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 28) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_28"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 29) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_29"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 30) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_30"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 31) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_31"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 32) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_32"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 33) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_33"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 34) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_34"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 35) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_35"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 36) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_36"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 37) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_37"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 38) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_38"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else if (randy == 39) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_39"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		} else {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "remnant_40"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x + xoff, y + yoff, z + zoff), BlockPos.containing(x + xoff, y + yoff, z + zoff),
							new StructurePlaceSettings().setRotation(Rotation.getRandom(_serverworld.random)).setMirror(Mirror.values()[_serverworld.random.nextInt(2)]).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		}
	}
}
