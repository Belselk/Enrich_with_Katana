
package katana.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import katana.procedures.CSK_atk_prProcedure;

import katana.init.EnrichWithKatanaModTabs;
import katana.init.EnrichWithKatanaModItems;

public class Csk14Item extends SwordItem {
	public Csk14Item() {
		super(new Tier() {
			public int getUses() {
				return 1014;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return -1f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 22;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EnrichWithKatanaModItems.BERYLLIUM_COPPER.get()));
			}
		}, 3, -1f, new Item.Properties().tab(EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		CSK_atk_prProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity);
		return retval;
	}
}
