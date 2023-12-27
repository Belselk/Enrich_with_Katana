
package katana.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import katana.procedures.SL_have_prProcedure;

import katana.init.EnrichWithKatanaModTabs;

import java.util.List;

public class SteelLanternItem extends Item {
	public SteelLanternItem() {
		super(new Item.Properties().tab(EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA).durability(100).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		SL_have_prProcedure.execute(world, entity);
	}
}
