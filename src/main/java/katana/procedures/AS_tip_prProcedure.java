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
public class AS_tip_prProcedure {
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
		if (itemstack.getItem() == EnrichWithKatanaModItems.ANTIDOTE_SYRINGE.get()) {
			if (!Screen.hasAltDown() && itemstack.getOrCreateTag().getBoolean("click")) {
				itemstack.getOrCreateTag().putBoolean("click", false);
			}
			if (itemstack.getOrCreateTag().getBoolean("Auto")) {
				tooltip.add(Component.literal(("\u00A73" + "\u81EA\u52D5\u89E3\u6BD2\u30E2\u30FC\u30C9 (Alt\u3067\u5909\u66F4)")));
				tooltip.add(Component.literal(("\u00A77" + "\u6BD2\u72B6\u614B\u306E\u6642\u5373\u5EA7\u306B\u56DE\u5FA9\u3067\u304D\u308B")));
			} else {
				tooltip.add(Component.literal(("\u00A73" + "\u624B\u52D5\u89E3\u6BD2\u30E2\u30FC\u30C9 (Alt\u3067\u5909\u66F4)")));
				tooltip.add(Component.literal(("\u00A77" + "\u4EFB\u610F\u306E\u30BF\u30A4\u30DF\u30F3\u30B0\u3067\u89E3\u6BD2\u3067\u304D\u308B")));
			}
			if (!itemstack.getOrCreateTag().getBoolean("click") && Screen.hasAltDown()) {
				itemstack.getOrCreateTag().putBoolean("Auto", (!itemstack.getOrCreateTag().getBoolean("Auto")));
				itemstack.getOrCreateTag().putBoolean("click", true);
			}
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(""));
				tooltip.add(Component.literal(("\u00A77" + "\u89E3\u6BD2\u85AC\u5264\u3092\u6D88\u8CBB\u3057\u3066\u6BD2\u72B6\u614B\u3092\u89E3\u9664\u3059\u308B\u3053\u3068\u304C\u3067\u304D\u308B")));
				tooltip.add(Component.literal(("\u00A77" + "\u4E00\u5B9A\u306E\u78BA\u7387\u3067\u4F7F\u7528\u6E08\u307F\u306E\u85AC\u5264\u5BB9\u5668\u3092\u56DE\u53CE\u3067\u304D\u308B")));
				tooltip.add(Component.literal(("\u00A73" + "\u30AF\u30FC\u30EB\u30BF\u30A4\u30E0" + "\u00A77" + "10s")));
			} else {
				tooltip.add(Component.literal((Component.translatable("tip.enrich_with_katana.press_shift").getString())));
			}
		} else if (itemstack.getItem() == EnrichWithKatanaModItems.ANTIDOTE_SOLUTION.get()) {
			tooltip.add(Component.literal(("\u00A77" + "\u89E3\u6BD2\u6CE8\u5C04\u5668\u7528\u306E\u9AD8\u6FC3\u5EA6\u89E3\u6BD2\u5264")));
		} else if (itemstack.getItem() == EnrichWithKatanaModItems.EMPTY_ANTIDOTE_VIAL.get()) {
			tooltip.add(Component.literal(("\u00A77" + "\u7A7A\u306E\u89E3\u6BD2\u5264\u5BB9\u5668")));
			tooltip.add(Component.literal(("\u00A77" + "\u4F5C\u696D\u53F0\u3001\u91B8\u9020\u53F0\u3067\u85AC\u5264\u3092\u8A70\u3081\u308B\u3053\u3068\u304C\u3067\u304D\u308B")));
		}
	}
}
