
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
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.world.inventory.FlavorInterfaceMenu;
import net.mcreator.endless_end.procedures.ResetFlavorBlockProcedure;
import net.mcreator.endless_end.procedures.PrintInformationProcedure;
import net.mcreator.endless_end.procedures.ManuallyTriggerFunctionProcedure;
import net.mcreator.endless_end.procedures.FlavorTextInputProcedure;
import net.mcreator.endless_end.procedures.ApplyFlavorDisplayNameProcedure;
import net.mcreator.endless_end.EndlessEndMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record FlavorInterfaceButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<FlavorInterfaceButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(EndlessEndMod.MODID, "flavor_interface_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FlavorInterfaceButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FlavorInterfaceButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new FlavorInterfaceButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<FlavorInterfaceButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final FlavorInterfaceButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = FlavorInterfaceMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			FlavorTextInputProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 1) {

			ManuallyTriggerFunctionProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			ResetFlavorBlockProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			PrintInformationProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ApplyFlavorDisplayNameProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EndlessEndMod.addNetworkMessage(FlavorInterfaceButtonMessage.TYPE, FlavorInterfaceButtonMessage.STREAM_CODEC, FlavorInterfaceButtonMessage::handleData);
	}
}
