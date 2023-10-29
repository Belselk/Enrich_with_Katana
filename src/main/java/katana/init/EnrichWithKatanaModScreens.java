
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package katana.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import katana.client.gui.HellfurnaceguiScreen;
import katana.client.gui.FurnaceRecipeViewerScreen;
import katana.client.gui.AntidoteSyringeguiScreen;
import katana.client.gui.AlloyFurnaceguiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EnrichWithKatanaModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(EnrichWithKatanaModMenus.ALLOY_FURNACEGUI.get(), AlloyFurnaceguiScreen::new);
			MenuScreens.register(EnrichWithKatanaModMenus.HELLFURNACEGUI.get(), HellfurnaceguiScreen::new);
			MenuScreens.register(EnrichWithKatanaModMenus.ANTIDOTE_SYRINGEGUI.get(), AntidoteSyringeguiScreen::new);
			MenuScreens.register(EnrichWithKatanaModMenus.FURNACE_RECIPE_VIEWER.get(), FurnaceRecipeViewerScreen::new);
		});
	}
}
