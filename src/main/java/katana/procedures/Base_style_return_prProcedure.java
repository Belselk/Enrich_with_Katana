package katana.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import katana.init.EnrichWithKatanaModItems;

public class Base_style_return_prProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (EnrichWithKatanaModItems.STEEL_KATANA.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
				|| EnrichWithKatanaModItems.REINFORCED_KATANA.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
				|| EnrichWithKatanaModItems.DIVINE_KATANA.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			return true;
		}
		return false;
	}
}
