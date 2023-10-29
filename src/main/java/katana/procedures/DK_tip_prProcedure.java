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
public class DK_tip_prProcedure {
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
		if (itemstack.getItem() == EnrichWithKatanaModItems.DIVINE_KATANA.get()) {
			tooltip.add(Component.literal(("\u00A77" + "\u4ED8\u4E0E\u5C5E\u6027" + "\u00A76" + "\u8056")));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A77" + "\u7834\u9B54\u306E\u529B\u3092\u5E2F\u3073\u305F\u92ED\u3044\u5200")));
				tooltip.add(Component.literal(("\u00A77" + "\u30A2\u30F3\u30C7\u30C3\u30C8\u3084\u8F1D\u304F\u6575\u306B\u5BFE\u3057\u3066\u9AD8\u3044\u30C0\u30E1\u30FC\u30B8\u3092\u4E0E\u3048\u308B")));
				tooltip.add(Component.literal(("\u00A73" + "\u901A\u5E38\u653B\u6483" + "\u00A77" + "\u7D20\u65E9\u304F\u5207\u308A\u3064\u3051\u8056\u306A\u308B\u65AC\u6483\u3092\u653E\u3064")));
				tooltip.add(Component.literal(("\u00A73" + "\u5149\u660E\u306E\u611F\u77E5" + "\u00A77" + "\u5468\u56F2\u306E\u6575\u3092\u63A2\u77E5\u3057\u30A2\u30F3\u30C7\u30C3\u30C8\u306E\u529B\u3092\u524A\u3050")));
				tooltip.add(Component.literal(("\u00A78" + "(\u00A73\u30AF\u30FC\u30EB\u30BF\u30A4\u30E0" + "\u00A78 30s" + " \u00A73\u6D88\u8CBB\u91CF" + "\u00A78 4\u6E80\u8179\u5EA6)")));
			} else {
				tooltip.add(Component.literal((Component.translatable("tip.enrich_with_katana.press_shift").getString())));
			}
		}
	}
}
