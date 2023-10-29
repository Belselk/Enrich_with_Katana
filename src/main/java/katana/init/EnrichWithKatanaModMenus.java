
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package katana.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import katana.world.inventory.HellfurnaceguiMenu;
import katana.world.inventory.FurnaceRecipeViewerMenu;
import katana.world.inventory.AntidoteSyringeguiMenu;
import katana.world.inventory.AlloyFurnaceguiMenu;

import katana.EnrichWithKatanaMod;

public class EnrichWithKatanaModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, EnrichWithKatanaMod.MODID);
	public static final RegistryObject<MenuType<AlloyFurnaceguiMenu>> ALLOY_FURNACEGUI = REGISTRY.register("alloy_furnacegui", () -> IForgeMenuType.create(AlloyFurnaceguiMenu::new));
	public static final RegistryObject<MenuType<HellfurnaceguiMenu>> HELLFURNACEGUI = REGISTRY.register("hellfurnacegui", () -> IForgeMenuType.create(HellfurnaceguiMenu::new));
	public static final RegistryObject<MenuType<AntidoteSyringeguiMenu>> ANTIDOTE_SYRINGEGUI = REGISTRY.register("antidote_syringegui", () -> IForgeMenuType.create(AntidoteSyringeguiMenu::new));
	public static final RegistryObject<MenuType<FurnaceRecipeViewerMenu>> FURNACE_RECIPE_VIEWER = REGISTRY.register("furnace_recipe_viewer", () -> IForgeMenuType.create(FurnaceRecipeViewerMenu::new));
}
