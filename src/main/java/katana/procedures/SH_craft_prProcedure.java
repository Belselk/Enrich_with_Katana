package katana.procedures;

import net.minecraft.world.item.ItemStack;

public class SH_craft_prProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putBoolean("Hammer", true);
	}
}
