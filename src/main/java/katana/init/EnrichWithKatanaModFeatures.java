
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package katana.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import katana.world.features.ores.BauxiteoreFeature;

import katana.EnrichWithKatanaMod;

@Mod.EventBusSubscriber
public class EnrichWithKatanaModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, EnrichWithKatanaMod.MODID);
	public static final RegistryObject<Feature<?>> BAUXITEORE = REGISTRY.register("bauxiteore", BauxiteoreFeature::feature);
}
