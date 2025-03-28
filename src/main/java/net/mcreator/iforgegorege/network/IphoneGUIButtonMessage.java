
package net.mcreator.iforgegorege.network;

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

import net.mcreator.iforgegorege.world.inventory.IphoneGUIMenu;
import net.mcreator.iforgegorege.procedures.IrongenProcedure;
import net.mcreator.iforgegorege.procedures.GoldgenProcedure;
import net.mcreator.iforgegorege.procedures.FlyProcedure;
import net.mcreator.iforgegorege.procedures.DiamondshopProcedure;
import net.mcreator.iforgegorege.IForgeGoregeMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record IphoneGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<IphoneGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(IForgeGoregeMod.MODID, "iphone_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, IphoneGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, IphoneGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new IphoneGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<IphoneGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final IphoneGUIButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = IphoneGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			IrongenProcedure.execute(entity);
		}
		if (buttonID == 1) {

			DiamondshopProcedure.execute(entity);
		}
		if (buttonID == 2) {

			GoldgenProcedure.execute(entity);
		}
		if (buttonID == 3) {

			FlyProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		IForgeGoregeMod.addNetworkMessage(IphoneGUIButtonMessage.TYPE, IphoneGUIButtonMessage.STREAM_CODEC, IphoneGUIButtonMessage::handleData);
	}
}
