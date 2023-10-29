
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package katana.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import katana.potion.BerylliumPoisonMobEffect;
import katana.potion.AdrenalineMobEffect;
import katana.potion.ActivationMobEffect;

import katana.EnrichWithKatanaMod;

public class EnrichWithKatanaModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EnrichWithKatanaMod.MODID);
	public static final RegistryObject<MobEffect> ACTIVATION = REGISTRY.register("activation", () -> new ActivationMobEffect());
	public static final RegistryObject<MobEffect> BERYLLIUM_POISON = REGISTRY.register("beryllium_poison", () -> new BerylliumPoisonMobEffect());
	public static final RegistryObject<MobEffect> ADRENALINE = REGISTRY.register("adrenaline", () -> new AdrenalineMobEffect());
}
