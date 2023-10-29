
package katana.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import katana.world.inventory.FurnaceRecipeViewerMenu;

import katana.procedures.FRS_set_prProcedure;
import katana.procedures.FRS_right_prProcedure;
import katana.procedures.FRS_left_prProcedure;
import katana.procedures.FRS_close_prProcedure;

import katana.EnrichWithKatanaMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FurnaceRecipeViewerButtonMessage {
	private final int buttonID, x, y, z;

	public FurnaceRecipeViewerButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public FurnaceRecipeViewerButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(FurnaceRecipeViewerButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(FurnaceRecipeViewerButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = FurnaceRecipeViewerMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			FRS_right_prProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			FRS_left_prProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			FRS_close_prProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			FRS_set_prProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EnrichWithKatanaMod.addNetworkMessage(FurnaceRecipeViewerButtonMessage.class, FurnaceRecipeViewerButtonMessage::buffer, FurnaceRecipeViewerButtonMessage::new, FurnaceRecipeViewerButtonMessage::handler);
	}
}
