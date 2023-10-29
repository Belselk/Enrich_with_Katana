package katana.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import katana.init.EnrichWithKatanaModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class Base_style_tooltip_prProcedure {
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
		if (EnrichWithKatanaModItems.STEEL_KATANA.get() == itemstack.getItem() || EnrichWithKatanaModItems.REINFORCED_KATANA.get() == itemstack.getItem() || EnrichWithKatanaModItems.DIVINE_KATANA.get() == itemstack.getItem()) {
			tooltip.add(Component.literal(("\u00A77" + "\u525B\u5263\u8853\u306E\u3068\u304D\uFF1A")));
			tooltip.add(Component.literal(("\u00A72" + "\u653B\u6483\u529B +8.3")));
			tooltip.add(Component.literal(("\u00A72" + "\u653B\u6483\u901F\u5EA6 -1")));
			tooltip.add(Component.literal(("\u00A72" + "\u30CE\u30C3\u30AF\u30D0\u30C3\u30AF\u8DDD\u96E2 +1")));
		}
	}
}
