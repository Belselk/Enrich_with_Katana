
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package katana.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import katana.item.WireItem;
import katana.item.TrailStickItem;
import katana.item.TamahaganeItem;
import katana.item.SteelingotItem;
import katana.item.SteelfishingrodItem;
import katana.item.SteelShearsItem;
import katana.item.SteelLanternItem;
import katana.item.SteelKatanaItem;
import katana.item.SteelHammerItem;
import katana.item.SimpleStickItem;
import katana.item.ReinforcedKatanaItem;
import katana.item.RecipepaperItem;
import katana.item.RecallPotionItem;
import katana.item.RawBauxiteItem;
import katana.item.LifecrystalItem;
import katana.item.GleamingsteelarmorItem;
import katana.item.EmptyAntidoteVialItem;
import katana.item.DivineTamahaganeItem;
import katana.item.DivineKatanaItem;
import katana.item.Csk14Item;
import katana.item.BerylliumCopperItem;
import katana.item.AntidoteSyringeItem;
import katana.item.AntidoteSolutionItem;
import katana.item.AluminumingotItem;
import katana.item.AlloyPowdersteelItem;
import katana.item.AlloyPowderberylliumcopperItem;
import katana.item.ActiveplasterItem;
import katana.item.ActivatebandageItem;

import katana.EnrichWithKatanaMod;

public class EnrichWithKatanaModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EnrichWithKatanaMod.MODID);
	public static final RegistryObject<Item> BAUXITEORE = block(EnrichWithKatanaModBlocks.BAUXITEORE, EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA);
	public static final RegistryObject<Item> RAW_BAUXITE = REGISTRY.register("raw_bauxite", () -> new RawBauxiteItem());
	public static final RegistryObject<Item> ALUMINUMINGOT = REGISTRY.register("aluminumingot", () -> new AluminumingotItem());
	public static final RegistryObject<Item> BLOCKOFALUMINUM = block(EnrichWithKatanaModBlocks.BLOCKOFALUMINUM, EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA);
	public static final RegistryObject<Item> WIRE = REGISTRY.register("wire", () -> new WireItem());
	public static final RegistryObject<Item> ALLOY_POWDERSTEEL = REGISTRY.register("alloy_powdersteel", () -> new AlloyPowdersteelItem());
	public static final RegistryObject<Item> STEELINGOT = REGISTRY.register("steelingot", () -> new SteelingotItem());
	public static final RegistryObject<Item> BLOCKOF_STEEL = block(EnrichWithKatanaModBlocks.BLOCKOF_STEEL, EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA);
	public static final RegistryObject<Item> ALLOY_POWDERBERYLLIUMCOPPER = REGISTRY.register("alloy_powderberylliumcopper", () -> new AlloyPowderberylliumcopperItem());
	public static final RegistryObject<Item> BERYLLIUM_COPPER = REGISTRY.register("beryllium_copper", () -> new BerylliumCopperItem());
	public static final RegistryObject<Item> TAMAHAGANE = REGISTRY.register("tamahagane", () -> new TamahaganeItem());
	public static final RegistryObject<Item> DIVINE_TAMAHAGANE = REGISTRY.register("divine_tamahagane", () -> new DivineTamahaganeItem());
	public static final RegistryObject<Item> BLOCKOF_BERYLLIUMCOPPER = block(EnrichWithKatanaModBlocks.BLOCKOF_BERYLLIUMCOPPER, EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA);
	public static final RegistryObject<Item> ALLOY_FURNACE = block(EnrichWithKatanaModBlocks.ALLOY_FURNACE, EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA);
	public static final RegistryObject<Item> HELL_FURNACE = block(EnrichWithKatanaModBlocks.HELL_FURNACE, EnrichWithKatanaModTabs.TAB_ENRICHWITHKATANA);
	public static final RegistryObject<Item> STEEL_KATANA = REGISTRY.register("steel_katana", () -> new SteelKatanaItem());
	public static final RegistryObject<Item> REINFORCED_KATANA = REGISTRY.register("reinforced_katana", () -> new ReinforcedKatanaItem());
	public static final RegistryObject<Item> CSK_14 = REGISTRY.register("csk_14", () -> new Csk14Item());
	public static final RegistryObject<Item> DIVINE_KATANA = REGISTRY.register("divine_katana", () -> new DivineKatanaItem());
	public static final RegistryObject<Item> GLEAMINGSTEELARMOR_HELMET = REGISTRY.register("gleamingsteelarmor_helmet", () -> new GleamingsteelarmorItem.Helmet());
	public static final RegistryObject<Item> GLEAMINGSTEELARMOR_CHESTPLATE = REGISTRY.register("gleamingsteelarmor_chestplate", () -> new GleamingsteelarmorItem.Chestplate());
	public static final RegistryObject<Item> GLEAMINGSTEELARMOR_LEGGINGS = REGISTRY.register("gleamingsteelarmor_leggings", () -> new GleamingsteelarmorItem.Leggings());
	public static final RegistryObject<Item> GLEAMINGSTEELARMOR_BOOTS = REGISTRY.register("gleamingsteelarmor_boots", () -> new GleamingsteelarmorItem.Boots());
	public static final RegistryObject<Item> STEEL_HAMMER = REGISTRY.register("steel_hammer", () -> new SteelHammerItem());
	public static final RegistryObject<Item> STEEL_LANTERN = REGISTRY.register("steel_lantern", () -> new SteelLanternItem());
	public static final RegistryObject<Item> STEELFISHINGROD = REGISTRY.register("steelfishingrod", () -> new SteelfishingrodItem());
	public static final RegistryObject<Item> STEEL_SHEARS = REGISTRY.register("steel_shears", () -> new SteelShearsItem());
	public static final RegistryObject<Item> ANTIDOTE_SYRINGE = REGISTRY.register("antidote_syringe", () -> new AntidoteSyringeItem());
	public static final RegistryObject<Item> ANTIDOTE_SOLUTION = REGISTRY.register("antidote_solution", () -> new AntidoteSolutionItem());
	public static final RegistryObject<Item> EMPTY_ANTIDOTE_VIAL = REGISTRY.register("empty_antidote_vial", () -> new EmptyAntidoteVialItem());
	public static final RegistryObject<Item> ACTIVEPLASTER = REGISTRY.register("activeplaster", () -> new ActiveplasterItem());
	public static final RegistryObject<Item> ACTIVATEBANDAGE = REGISTRY.register("activatebandage", () -> new ActivatebandageItem());
	public static final RegistryObject<Item> LIFECRYSTAL = REGISTRY.register("lifecrystal", () -> new LifecrystalItem());
	public static final RegistryObject<Item> RECALL_POTION = REGISTRY.register("recall_potion", () -> new RecallPotionItem());
	public static final RegistryObject<Item> RECIPEPAPER = REGISTRY.register("recipepaper", () -> new RecipepaperItem());
	public static final RegistryObject<Item> SIMPLE_STICK = REGISTRY.register("simple_stick", () -> new SimpleStickItem());
	public static final RegistryObject<Item> TRAIL_STICK = REGISTRY.register("trail_stick", () -> new TrailStickItem());
	public static final RegistryObject<Item> LIGHT_AIR = block(EnrichWithKatanaModBlocks.LIGHT_AIR, null);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
