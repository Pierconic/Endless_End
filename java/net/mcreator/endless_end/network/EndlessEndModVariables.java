package net.mcreator.endless_end.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.endless_end.EndlessEndMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class EndlessEndModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, EndlessEndMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		EndlessEndMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		EndlessEndMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.Warpcooldown = original.Warpcooldown;
			clone.EPWhiteX = original.EPWhiteX;
			clone.EPWhiteY = original.EPWhiteY;
			clone.EPWhiteZ = original.EPWhiteZ;
			clone.EPWhiteDimension = original.EPWhiteDimension;
			clone.EPRedX = original.EPRedX;
			clone.EPRedY = original.EPRedY;
			clone.EPRedZ = original.EPRedZ;
			clone.EPRedDimension = original.EPRedDimension;
			clone.EPOrangeX = original.EPOrangeX;
			clone.EPOrangeY = original.EPOrangeY;
			clone.EPOrangeZ = original.EPOrangeZ;
			clone.EPOrangeDimension = original.EPOrangeDimension;
			clone.EPYellowX = original.EPYellowX;
			clone.EPYellowY = original.EPYellowY;
			clone.EPYellowZ = original.EPYellowZ;
			clone.EPYellowDimension = original.EPYellowDimension;
			clone.EPLimeX = original.EPLimeX;
			clone.EPLimeY = original.EPLimeY;
			clone.EPLimeZ = original.EPLimeZ;
			clone.EPLimeDimension = original.EPLimeDimension;
			clone.EPGreenX = original.EPGreenX;
			clone.EPGreenY = original.EPGreenY;
			clone.EPGreenZ = original.EPGreenZ;
			clone.EPGreenDimension = original.EPGreenDimension;
			clone.EPCyanX = original.EPCyanX;
			clone.EPCyanY = original.EPCyanY;
			clone.EPCyanZ = original.EPCyanZ;
			clone.EPCyanDimension = original.EPCyanDimension;
			clone.EPLightBlueX = original.EPLightBlueX;
			clone.EPLightBlueY = original.EPLightBlueY;
			clone.EPLightBlueZ = original.EPLightBlueZ;
			clone.EPLightBlueDimension = original.EPLightBlueDimension;
			clone.EPBlueX = original.EPBlueX;
			clone.EPBlueY = original.EPBlueY;
			clone.EPBlueZ = original.EPBlueZ;
			clone.EPBlueDimension = original.EPBlueDimension;
			clone.EPPurpleX = original.EPPurpleX;
			clone.EPPurpleY = original.EPPurpleY;
			clone.EPPurpleZ = original.EPPurpleZ;
			clone.EPPurpleDimension = original.EPPurpleDimension;
			clone.EPPinkX = original.EPPinkX;
			clone.EPPinkY = original.EPPinkY;
			clone.EPPinkZ = original.EPPinkZ;
			clone.EPPinkDimension = original.EPPinkDimension;
			clone.EPMagentaX = original.EPMagentaX;
			clone.EPMagentaY = original.EPMagentaY;
			clone.EPMagentaZ = original.EPMagentaZ;
			clone.EPMagentaDimension = original.EPMagentaDimension;
			clone.EPBrownX = original.EPBrownX;
			clone.EPBrownY = original.EPBrownY;
			clone.EPBrownZ = original.EPBrownZ;
			clone.EPBrownDimension = original.EPBrownDimension;
			clone.EPGrayX = original.EPGrayX;
			clone.EPGrayY = original.EPGrayY;
			clone.EPGrayZ = original.EPGrayZ;
			clone.EPGrayDimension = original.EPGrayDimension;
			clone.EPDarkGrayX = original.EPDarkGrayX;
			clone.EPDarkGrayY = original.EPDarkGrayY;
			clone.EPDarkGrayZ = original.EPDarkGrayZ;
			clone.EPDarkGrayDimension = original.EPDarkGrayDimension;
			clone.EPBlackX = original.EPBlackX;
			clone.EPBlackY = original.EPBlackY;
			clone.EPBlackZ = original.EPBlackZ;
			clone.EPBlackDimension = original.EPBlackDimension;
			clone.WandX = original.WandX;
			clone.WandY = original.WandY;
			clone.WandZ = original.WandZ;
			clone.CloneX = original.CloneX;
			clone.CloneY = original.CloneY;
			clone.CloneZ = original.CloneZ;
			clone.gesture = original.gesture;
			clone.gauntlet_reach = original.gauntlet_reach;
			clone.EyeballDirection = original.EyeballDirection;
			clone.Eyeball_Agitation = original.Eyeball_Agitation;
			clone.singing_sand_cooldown = original.singing_sand_cooldown;
			clone.PulseCooldown = original.PulseCooldown;
			clone.ProximityPower = original.ProximityPower;
			clone.Stronghold_X = original.Stronghold_X;
			clone.Stronghold_Z = original.Stronghold_Z;
			if (!event.isWasDeath()) {
				clone.fowards_polarity = original.fowards_polarity;
				clone.upwards_polarity = original.upwards_polarity;
				clone.downwards_polarity = original.downwards_polarity;
				clone.left_polarity = original.left_polarity;
				clone.right_polarity = original.right_polarity;
				clone.backwards_polarity = original.backwards_polarity;
				clone.ascension_timer = original.ascension_timer;
				clone.ascension_sfx = original.ascension_sfx;
				clone.radiance = original.radiance;
				clone.shock_frames = original.shock_frames;
				clone.CorruptedHearts = original.CorruptedHearts;
				clone.CurseType = original.CurseType;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "endless_end_worldvars";

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "endless_end_mapvars";
		public boolean citadel_placed = false;
		public double portal_height = 0;
		public boolean awaiting_portal = false;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			citadel_placed = nbt.getBoolean("citadel_placed");
			portal_height = nbt.getDouble("portal_height");
			awaiting_portal = nbt.getBoolean("awaiting_portal");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putBoolean("citadel_placed", citadel_placed);
			nbt.putDouble("portal_height", portal_height);
			nbt.putBoolean("awaiting_portal", awaiting_portal);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(EndlessEndMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public double Warpcooldown = 0;
		public double EPWhiteX = 0;
		public double EPWhiteY = 0;
		public double EPWhiteZ = 0;
		public double EPWhiteDimension = 0;
		public double EPRedX = 0;
		public double EPRedY = 0;
		public double EPRedZ = 0;
		public double EPRedDimension = 0;
		public double EPOrangeX = 0;
		public double EPOrangeY = 0;
		public double EPOrangeZ = 0;
		public double EPOrangeDimension = 0;
		public double EPYellowX = 0;
		public double EPYellowY = 0;
		public double EPYellowZ = 0;
		public double EPYellowDimension = 0;
		public double EPLimeX = 0;
		public double EPLimeY = 0;
		public double EPLimeZ = 0;
		public double EPLimeDimension = 0;
		public double EPGreenX = 0;
		public double EPGreenY = 0;
		public double EPGreenZ = 0;
		public double EPGreenDimension = 0;
		public double EPCyanX = 0;
		public double EPCyanY = 0;
		public double EPCyanZ = 0;
		public double EPCyanDimension = 0;
		public double EPLightBlueX = 0;
		public double EPLightBlueY = 0;
		public double EPLightBlueZ = 0;
		public double EPLightBlueDimension = 0;
		public double EPBlueX = 0;
		public double EPBlueY = 0;
		public double EPBlueZ = 0;
		public double EPBlueDimension = 0;
		public double EPPurpleX = 0;
		public double EPPurpleY = 0;
		public double EPPurpleZ = 0;
		public double EPPurpleDimension = 0;
		public double EPPinkX = 0;
		public double EPPinkY = 0;
		public double EPPinkZ = 0;
		public double EPPinkDimension = 0;
		public double EPMagentaX = 0;
		public double EPMagentaY = 0;
		public double EPMagentaZ = 0;
		public double EPMagentaDimension = 0;
		public double EPBrownX = 0;
		public double EPBrownY = 0;
		public double EPBrownZ = 0;
		public double EPBrownDimension = 0;
		public double EPGrayX = 0;
		public double EPGrayY = 0;
		public double EPGrayZ = 0;
		public double EPGrayDimension = 0;
		public double EPDarkGrayX = 0;
		public double EPDarkGrayY = 0;
		public double EPDarkGrayZ = 0;
		public double EPDarkGrayDimension = 0;
		public double EPBlackX = 0;
		public double EPBlackY = 0;
		public double EPBlackZ = 0;
		public double EPBlackDimension = 0;
		public boolean fowards_polarity = false;
		public boolean upwards_polarity = false;
		public boolean downwards_polarity = false;
		public boolean left_polarity = false;
		public boolean right_polarity = false;
		public boolean backwards_polarity = false;
		public double ascension_timer = 0;
		public double ascension_sfx = 0;
		public double radiance = 0;
		public double WandX = 0;
		public double WandY = 0;
		public double WandZ = 0;
		public double CloneX = 0;
		public double CloneY = 0;
		public double CloneZ = 0;
		public double shock_frames = 0;
		public double gesture = 0;
		public boolean gauntlet_reach = false;
		public double EyeballDirection = 0;
		public double Eyeball_Agitation = 0;
		public double CorruptedHearts = 0;
		public double CurseType = 0;
		public double singing_sand_cooldown = 0;
		public double PulseCooldown = 0;
		public double ProximityPower = 0;
		public double Stronghold_X = 0;
		public double Stronghold_Z = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Warpcooldown", Warpcooldown);
			nbt.putDouble("EPWhiteX", EPWhiteX);
			nbt.putDouble("EPWhiteY", EPWhiteY);
			nbt.putDouble("EPWhiteZ", EPWhiteZ);
			nbt.putDouble("EPWhiteDimension", EPWhiteDimension);
			nbt.putDouble("EPRedX", EPRedX);
			nbt.putDouble("EPRedY", EPRedY);
			nbt.putDouble("EPRedZ", EPRedZ);
			nbt.putDouble("EPRedDimension", EPRedDimension);
			nbt.putDouble("EPOrangeX", EPOrangeX);
			nbt.putDouble("EPOrangeY", EPOrangeY);
			nbt.putDouble("EPOrangeZ", EPOrangeZ);
			nbt.putDouble("EPOrangeDimension", EPOrangeDimension);
			nbt.putDouble("EPYellowX", EPYellowX);
			nbt.putDouble("EPYellowY", EPYellowY);
			nbt.putDouble("EPYellowZ", EPYellowZ);
			nbt.putDouble("EPYellowDimension", EPYellowDimension);
			nbt.putDouble("EPLimeX", EPLimeX);
			nbt.putDouble("EPLimeY", EPLimeY);
			nbt.putDouble("EPLimeZ", EPLimeZ);
			nbt.putDouble("EPLimeDimension", EPLimeDimension);
			nbt.putDouble("EPGreenX", EPGreenX);
			nbt.putDouble("EPGreenY", EPGreenY);
			nbt.putDouble("EPGreenZ", EPGreenZ);
			nbt.putDouble("EPGreenDimension", EPGreenDimension);
			nbt.putDouble("EPCyanX", EPCyanX);
			nbt.putDouble("EPCyanY", EPCyanY);
			nbt.putDouble("EPCyanZ", EPCyanZ);
			nbt.putDouble("EPCyanDimension", EPCyanDimension);
			nbt.putDouble("EPLightBlueX", EPLightBlueX);
			nbt.putDouble("EPLightBlueY", EPLightBlueY);
			nbt.putDouble("EPLightBlueZ", EPLightBlueZ);
			nbt.putDouble("EPLightBlueDimension", EPLightBlueDimension);
			nbt.putDouble("EPBlueX", EPBlueX);
			nbt.putDouble("EPBlueY", EPBlueY);
			nbt.putDouble("EPBlueZ", EPBlueZ);
			nbt.putDouble("EPBlueDimension", EPBlueDimension);
			nbt.putDouble("EPPurpleX", EPPurpleX);
			nbt.putDouble("EPPurpleY", EPPurpleY);
			nbt.putDouble("EPPurpleZ", EPPurpleZ);
			nbt.putDouble("EPPurpleDimension", EPPurpleDimension);
			nbt.putDouble("EPPinkX", EPPinkX);
			nbt.putDouble("EPPinkY", EPPinkY);
			nbt.putDouble("EPPinkZ", EPPinkZ);
			nbt.putDouble("EPPinkDimension", EPPinkDimension);
			nbt.putDouble("EPMagentaX", EPMagentaX);
			nbt.putDouble("EPMagentaY", EPMagentaY);
			nbt.putDouble("EPMagentaZ", EPMagentaZ);
			nbt.putDouble("EPMagentaDimension", EPMagentaDimension);
			nbt.putDouble("EPBrownX", EPBrownX);
			nbt.putDouble("EPBrownY", EPBrownY);
			nbt.putDouble("EPBrownZ", EPBrownZ);
			nbt.putDouble("EPBrownDimension", EPBrownDimension);
			nbt.putDouble("EPGrayX", EPGrayX);
			nbt.putDouble("EPGrayY", EPGrayY);
			nbt.putDouble("EPGrayZ", EPGrayZ);
			nbt.putDouble("EPGrayDimension", EPGrayDimension);
			nbt.putDouble("EPDarkGrayX", EPDarkGrayX);
			nbt.putDouble("EPDarkGrayY", EPDarkGrayY);
			nbt.putDouble("EPDarkGrayZ", EPDarkGrayZ);
			nbt.putDouble("EPDarkGrayDimension", EPDarkGrayDimension);
			nbt.putDouble("EPBlackX", EPBlackX);
			nbt.putDouble("EPBlackY", EPBlackY);
			nbt.putDouble("EPBlackZ", EPBlackZ);
			nbt.putDouble("EPBlackDimension", EPBlackDimension);
			nbt.putBoolean("fowards_polarity", fowards_polarity);
			nbt.putBoolean("upwards_polarity", upwards_polarity);
			nbt.putBoolean("downwards_polarity", downwards_polarity);
			nbt.putBoolean("left_polarity", left_polarity);
			nbt.putBoolean("right_polarity", right_polarity);
			nbt.putBoolean("backwards_polarity", backwards_polarity);
			nbt.putDouble("ascension_timer", ascension_timer);
			nbt.putDouble("ascension_sfx", ascension_sfx);
			nbt.putDouble("radiance", radiance);
			nbt.putDouble("WandX", WandX);
			nbt.putDouble("WandY", WandY);
			nbt.putDouble("WandZ", WandZ);
			nbt.putDouble("CloneX", CloneX);
			nbt.putDouble("CloneY", CloneY);
			nbt.putDouble("CloneZ", CloneZ);
			nbt.putDouble("shock_frames", shock_frames);
			nbt.putDouble("gesture", gesture);
			nbt.putBoolean("gauntlet_reach", gauntlet_reach);
			nbt.putDouble("EyeballDirection", EyeballDirection);
			nbt.putDouble("Eyeball_Agitation", Eyeball_Agitation);
			nbt.putDouble("CorruptedHearts", CorruptedHearts);
			nbt.putDouble("CurseType", CurseType);
			nbt.putDouble("singing_sand_cooldown", singing_sand_cooldown);
			nbt.putDouble("PulseCooldown", PulseCooldown);
			nbt.putDouble("ProximityPower", ProximityPower);
			nbt.putDouble("Stronghold_X", Stronghold_X);
			nbt.putDouble("Stronghold_Z", Stronghold_Z);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			Warpcooldown = nbt.getDouble("Warpcooldown");
			EPWhiteX = nbt.getDouble("EPWhiteX");
			EPWhiteY = nbt.getDouble("EPWhiteY");
			EPWhiteZ = nbt.getDouble("EPWhiteZ");
			EPWhiteDimension = nbt.getDouble("EPWhiteDimension");
			EPRedX = nbt.getDouble("EPRedX");
			EPRedY = nbt.getDouble("EPRedY");
			EPRedZ = nbt.getDouble("EPRedZ");
			EPRedDimension = nbt.getDouble("EPRedDimension");
			EPOrangeX = nbt.getDouble("EPOrangeX");
			EPOrangeY = nbt.getDouble("EPOrangeY");
			EPOrangeZ = nbt.getDouble("EPOrangeZ");
			EPOrangeDimension = nbt.getDouble("EPOrangeDimension");
			EPYellowX = nbt.getDouble("EPYellowX");
			EPYellowY = nbt.getDouble("EPYellowY");
			EPYellowZ = nbt.getDouble("EPYellowZ");
			EPYellowDimension = nbt.getDouble("EPYellowDimension");
			EPLimeX = nbt.getDouble("EPLimeX");
			EPLimeY = nbt.getDouble("EPLimeY");
			EPLimeZ = nbt.getDouble("EPLimeZ");
			EPLimeDimension = nbt.getDouble("EPLimeDimension");
			EPGreenX = nbt.getDouble("EPGreenX");
			EPGreenY = nbt.getDouble("EPGreenY");
			EPGreenZ = nbt.getDouble("EPGreenZ");
			EPGreenDimension = nbt.getDouble("EPGreenDimension");
			EPCyanX = nbt.getDouble("EPCyanX");
			EPCyanY = nbt.getDouble("EPCyanY");
			EPCyanZ = nbt.getDouble("EPCyanZ");
			EPCyanDimension = nbt.getDouble("EPCyanDimension");
			EPLightBlueX = nbt.getDouble("EPLightBlueX");
			EPLightBlueY = nbt.getDouble("EPLightBlueY");
			EPLightBlueZ = nbt.getDouble("EPLightBlueZ");
			EPLightBlueDimension = nbt.getDouble("EPLightBlueDimension");
			EPBlueX = nbt.getDouble("EPBlueX");
			EPBlueY = nbt.getDouble("EPBlueY");
			EPBlueZ = nbt.getDouble("EPBlueZ");
			EPBlueDimension = nbt.getDouble("EPBlueDimension");
			EPPurpleX = nbt.getDouble("EPPurpleX");
			EPPurpleY = nbt.getDouble("EPPurpleY");
			EPPurpleZ = nbt.getDouble("EPPurpleZ");
			EPPurpleDimension = nbt.getDouble("EPPurpleDimension");
			EPPinkX = nbt.getDouble("EPPinkX");
			EPPinkY = nbt.getDouble("EPPinkY");
			EPPinkZ = nbt.getDouble("EPPinkZ");
			EPPinkDimension = nbt.getDouble("EPPinkDimension");
			EPMagentaX = nbt.getDouble("EPMagentaX");
			EPMagentaY = nbt.getDouble("EPMagentaY");
			EPMagentaZ = nbt.getDouble("EPMagentaZ");
			EPMagentaDimension = nbt.getDouble("EPMagentaDimension");
			EPBrownX = nbt.getDouble("EPBrownX");
			EPBrownY = nbt.getDouble("EPBrownY");
			EPBrownZ = nbt.getDouble("EPBrownZ");
			EPBrownDimension = nbt.getDouble("EPBrownDimension");
			EPGrayX = nbt.getDouble("EPGrayX");
			EPGrayY = nbt.getDouble("EPGrayY");
			EPGrayZ = nbt.getDouble("EPGrayZ");
			EPGrayDimension = nbt.getDouble("EPGrayDimension");
			EPDarkGrayX = nbt.getDouble("EPDarkGrayX");
			EPDarkGrayY = nbt.getDouble("EPDarkGrayY");
			EPDarkGrayZ = nbt.getDouble("EPDarkGrayZ");
			EPDarkGrayDimension = nbt.getDouble("EPDarkGrayDimension");
			EPBlackX = nbt.getDouble("EPBlackX");
			EPBlackY = nbt.getDouble("EPBlackY");
			EPBlackZ = nbt.getDouble("EPBlackZ");
			EPBlackDimension = nbt.getDouble("EPBlackDimension");
			fowards_polarity = nbt.getBoolean("fowards_polarity");
			upwards_polarity = nbt.getBoolean("upwards_polarity");
			downwards_polarity = nbt.getBoolean("downwards_polarity");
			left_polarity = nbt.getBoolean("left_polarity");
			right_polarity = nbt.getBoolean("right_polarity");
			backwards_polarity = nbt.getBoolean("backwards_polarity");
			ascension_timer = nbt.getDouble("ascension_timer");
			ascension_sfx = nbt.getDouble("ascension_sfx");
			radiance = nbt.getDouble("radiance");
			WandX = nbt.getDouble("WandX");
			WandY = nbt.getDouble("WandY");
			WandZ = nbt.getDouble("WandZ");
			CloneX = nbt.getDouble("CloneX");
			CloneY = nbt.getDouble("CloneY");
			CloneZ = nbt.getDouble("CloneZ");
			shock_frames = nbt.getDouble("shock_frames");
			gesture = nbt.getDouble("gesture");
			gauntlet_reach = nbt.getBoolean("gauntlet_reach");
			EyeballDirection = nbt.getDouble("EyeballDirection");
			Eyeball_Agitation = nbt.getDouble("Eyeball_Agitation");
			CorruptedHearts = nbt.getDouble("CorruptedHearts");
			CurseType = nbt.getDouble("CurseType");
			singing_sand_cooldown = nbt.getDouble("singing_sand_cooldown");
			PulseCooldown = nbt.getDouble("PulseCooldown");
			ProximityPower = nbt.getDouble("ProximityPower");
			Stronghold_X = nbt.getDouble("Stronghold_X");
			Stronghold_Z = nbt.getDouble("Stronghold_Z");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(EndlessEndMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
