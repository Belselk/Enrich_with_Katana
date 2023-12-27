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
public class SK_tip_prProcedure {
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
		if (itemstack.getItem() == EnrichWithKatanaModItems.STEEL_KATANA.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A77" + "\u92ED\u3044\u7247\u5203\u306E\u5263")));
				tooltip.add(Component.literal(("\u00A77" + "\u6226\u95D8\u529B\u306F\u9AD8\u3044\u304C\u3001\u8010\u4E45\u6027\u306F\u9AD8\u304F\u306A\u3044")));
				tooltip.add(Component.literal(("\u00A73" + "\u901A\u5E38" + "\u00A77" + "\u7D20\u65E9\u304F\u5207\u308A\u3064\u3051\u5468\u56F2\u306B\u3082\u8FFD\u52A0\u3067\u65AC\u6483\u3092\u653E\u3064")));
				tooltip.add(Component.literal(("\u00A73" + "\u7A81\u304D " + "\u00A77" + "\u9632\u5FA1\u529B\u3092\u7121\u8996\u3059\u308B\u92ED\u3044\u7A81\u304D\u3092\u653E\u3064")));
			} else {
				tooltip.add(Component.literal((Component.translatable("tip.enrich_with_katana.press_shift").getString())));
			}
		} else if (itemstack.getItem() == EnrichWithKatanaModItems.REINFORCED_KATANA.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("\u00A77" + "\u5F37\u5316\u3055\u308C\u305F\u92ED\u3044\u7247\u5203\u306E\u5263")));
				tooltip.add(Component.literal(("\u00A77" + "\u8010\u4E45\u6027\u304C\u8457\u3057\u304F\u5411\u4E0A\u3057\u305F")));
				tooltip.add(Component.literal(("\u00A73" + "\u901A\u5E38" + "\u00A77" + "\u7D20\u65E9\u304F\u5207\u308A\u3064\u3051\u5468\u56F2\u306B\u3082\u8FFD\u52A0\u3067\u65AC\u6483\u3092\u653E\u3064")));
				tooltip.add(Component.literal(("\u00A73" + "\u7A81\u304D " + "\u00A77" + "\u9632\u5FA1\u529B\u3092\u7121\u8996\u3059\u308B\u92ED\u3044\u7A81\u304D\u3092\u653E\u3064")));
			} else {
				tooltip.add(Component.literal((Component.translatable("tip.enrich_with_katana.press_shift").getString())));
			}
		}
	}
}
