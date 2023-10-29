
package katana.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.entity.Entity;

import katana.procedures.SL_FR_have_prProcedure;

import katana.init.EnrichWithKatanaModTabs;
import katana.init.EnrichWithKatanaModItems;

import java.util.List;

public class SteelfishingrodItem extends FishingRodItem {
	public SteelfishingrodItem() {
		super(new Item.Properties().tab(EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA).durability(96));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return List.of(EnrichWithKatanaModItems.WIRE.get()).contains(repairitem.getItem());
	}

	@Override
	public int getEnchantmentValue() {
		return 8;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		SL_FR_have_prProcedure.execute(entity);
	}
}
