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
public class CSK_tip_prProcedure {
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
		if (itemstack.getItem() == EnrichWithKatanaModItems.CSK_14.get()) {
			if ((itemstack).getDamageValue() <= (itemstack).getMaxDamage() * 0.5) {
				tooltip.add(Component.literal(("\u00A77" + "\u4ED8\u4E0E\u5C5E\u6027 " + "\u00A75\u00A7l" + "\u6BD2")));
			}
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A77" + "\u8010\u4E45\u304C\u5927\u304D\u304F\u6D88\u8017\u3057\u3066\u3044\u308B\u3068\u304D")));
				tooltip.add(Component.literal(("\u00A77" + "\u65AC\u308A\u3064\u3051\u308B\u3054\u3068\u306B\u4E00\u5B9A\u78BA\u7387\u3067\u30D9\u30EA\u30EA\u30A6\u30E0\u6BD2\u3092\u4ED8\u4E0E\u3059\u308B")));
				tooltip.add(Component.literal("\u00A78\u00A7o[Combat Shock Knife - 14]"));
			} else {
				tooltip.add(Component.literal((Component.translatable("tip.enrich_with_katana.press_shift").getString())));
			}
		}
	}
}
