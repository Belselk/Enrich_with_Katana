
package katana.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import katana.init.EnrichWithKatanaModTabs;

public class TamahaganeItem extends Item {
	public TamahaganeItem() {
		super(new Item.Properties().tab(EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA).stacksTo(64).rarity(Rarity.COMMON));
	}
}