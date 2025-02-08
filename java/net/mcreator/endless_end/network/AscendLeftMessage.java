
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

import net.mcreator.endless_end.procedures.SetLeftPolarityProcedure;
import net.mcreator.endless_end.procedures.ResetLeftPolarityProcedure;
import net.mcreator.endless_end.EndlessEndMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record AscendLeftMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<AscendLeftMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(EndlessEndMod.MODID, "key_ascend_left"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AscendLeftMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AscendLeftMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new AscendLeftMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<AscendLeftMessage> type() {
		return TYPE;
	}

	public static void handleData(final AscendLeftMessage message, final IPayloadContext context) {
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

			SetLeftPolarityProcedure.execute(entity);
		}
		if (type == 1) {

			ResetLeftPolarityProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EndlessEndMod.addNetworkMessage(AscendLeftMessage.TYPE, AscendLeftMessage.STREAM_CODEC, AscendLeftMessage::handleData);
	}
}
