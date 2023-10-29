package katana.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import katana.init.EnrichWithKatanaModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class TS_tip_prProcedure {
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == EnrichWithKatanaModItems.TRAIL_STICK.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A77" + "\u00A7l\u7D20\u65E9\u304F\u00A7r\u00A77\u6804\u990A\u3092\u6442\u53D6\u3067\u304D")));
				tooltip.add(Component.literal(("\u00A77" + "\u5927\u91CF\u306B\u6301\u3061\u904B\u3079\u308B\u00A7l\u00A7n\u30A2\u30EB\u30DF\u5305\u88C5\u00A7r\u00A77\u30E2\u30C7\u30EB")));
			} else {
				tooltip.add(Component.literal((Component.translatable("tip.enrich_with_katana.press_shift").getString())));
			}
		}
		if (itemstack.getItem() == EnrichWithKatanaModItems.SIMPLE_STICK.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A77" + "\u00A7l\u7D20\u65E9\u304F\u00A7r\u00A77\u6804\u990A\u3092\u6442\u53D6\u3067\u304D")));
				tooltip.add(Component.literal(("\u00A77" + "\u7C21\u5358\u306B\u4F5C\u6210\u3067\u304D\u308B\u00A7l\u00A7n\u7D19\u5305\u88C5\u00A7r\u00A77\u30E2\u30C7\u30EB")));
			} else {
				tooltip.add(Component.literal((Component.translatable("tip.enrich_with_katana.press_shift").getString())));
			}
		}
	}
}
