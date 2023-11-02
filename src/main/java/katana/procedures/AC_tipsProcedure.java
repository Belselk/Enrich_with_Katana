package katana.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import katana.init.EnrichWithKatanaModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class AC_tipsProcedure {
	@OnlyIn(Dist.CLIENT)
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
		double consumption = 0;
		if (itemstack.getItem() == EnrichWithKatanaModItems.ACTIVEPLASTER.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A77" + "\u4F7F\u7528\u3059\u308B\u3053\u3068\u3067\u5373\u5EA7\u306B\u56DE\u5FA9\u3059\u308B\u3053\u3068\u304C\u3067\u304D\u308B")));
				tooltip.add(Component.literal(("\u00A77" + "\u4F7F\u7528\u3059\u308B\u3068\u904E\u6D3B\u6027\u72B6\u614B\u306B\u306A\u308A\u4E00\u5B9A\u6642\u9593\u4F7F\u7528\u3067\u304D\u306A\u304F\u306A\u308B")));
				tooltip.add(Component.literal(("\u00A73" + "\u56DE\u5FA9\u91CF:" + "\u00A77" + "6")));
				tooltip.add(Component.literal(("\u00A73" + "\u30AF\u30FC\u30EB\u30BF\u30A4\u30E0:" + "\u00A77" + "15s")));
			} else {
				tooltip.add(Component.literal((Component.translatable("tip.enrich_with_katana.press_shift").getString())));
			}
		}
	}
}
