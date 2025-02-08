
package net.mcreator.endless_end.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.endless_end.procedures.SetBackwardsPolarityProcedure;
import net.mcreator.endless_end.procedures.ResetBackwardsPolarityProcedure;
import net.mcreator.endless_end.EndlessEndMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record AscendBackwardsMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<AscendBackwardsMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(EndlessEndMod.MODID, "key_ascend_backwards"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AscendBackwardsMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AscendBackwardsMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new AscendBackwardsMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<AscendBackwardsMessage> type() {
		return TYPE;
	}

	public static void handleData(final AscendBackwardsMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			SetBackwardsPolarityProcedure.execute(entity);
		}
		if (type == 1) {

			ResetBackwardsPolarityProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EndlessEndMod.addNetworkMessage(AscendBackwardsMessage.TYPE, AscendBackwardsMessage.STREAM_CODEC, AscendBackwardsMessage::handleData);
	}
}
