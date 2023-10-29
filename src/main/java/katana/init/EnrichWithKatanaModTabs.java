
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package katana.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class EnrichWithKatanaModTabs {
	public static CreativeModeTab TAB_ENRICHWITHKATANA;

	public static void load() {
		TAB_ENRICHWITHKATANA = new CreativeModeTab("tabenrichwithkatana") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(EnrichWithKatanaModItems.REINFORCED_KATANA.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
