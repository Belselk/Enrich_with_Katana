
package katana.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import katana.init.EnrichWithKatanaModTabs;

import java.util.List;

public class DivineTamahaganeItem extends Item {
	public DivineTamahaganeItem() {
		super(new Item.Properties().tab(EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}
}
