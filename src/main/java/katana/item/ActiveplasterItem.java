
package katana.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import katana.procedures.AC_usedProcedure;

import katana.init.EnrichWithKatanaModTabs;

public class ActiveplasterItem extends Item {
	public ActiveplasterItem() {
		super(new Item.Properties().tab(EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA).stacksTo(32).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 1;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		AC_usedProcedure.execute(world, x, y, z, entity, itemstack);
		return ar;
	}
}
