package katana.procedures;

import net.minecraft.world.item.ItemStack;

public class RP_grow_prProcedure {
	public static boolean execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getBoolean("cheak");
	}
}
