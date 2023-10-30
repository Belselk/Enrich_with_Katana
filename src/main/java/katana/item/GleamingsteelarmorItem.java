
package katana.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import katana.init.EnrichWithKatanaModTabs;
import katana.init.EnrichWithKatanaModItems;

public abstract class GleamingsteelarmorItem extends ArmorItem {
	public GleamingsteelarmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 22;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{2, 5, 7, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 11;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EnrichWithKatanaModItems.STEELINGOT.get()), new ItemStack(EnrichWithKatanaModItems.BERYLLIUM_COPPER.get()));
			}

			@Override
			public String getName() {
				return "gleamingsteelarmor";
			}

			@Override
			public float getToughness() {
				return 0.5f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.2f;
			}
		}, slot, properties);
	}

	public static class Helmet extends GleamingsteelarmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "enrich_with_katana:textures/models/armor/gleamingsteelarmor_layer_1.png";
		}
	}

	public static class Chestplate extends GleamingsteelarmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "enrich_with_katana:textures/models/armor/gleamingsteelarmor_layer_1.png";
		}
	}

	public static class Leggings extends GleamingsteelarmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "enrich_with_katana:textures/models/armor/gleamingsteelarmor_layer_2.png";
		}
	}

	public static class Boots extends GleamingsteelarmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "enrich_with_katana:textures/models/armor/gleamingsteelarmor_layer_1.png";
		}
	}
}