
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package katana.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import katana.EnrichWithKatanaMod;

public class EnrichWithKatanaModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EnrichWithKatanaMod.MODID);
	public static final RegistryObject<SoundEvent> STYLE_CHANGE = REGISTRY.register("style_change", () -> new SoundEvent(new ResourceLocation("enrich_with_katana", "style_change")));
	public static final RegistryObject<SoundEvent> NO_SE = REGISTRY.register("no_se", () -> new SoundEvent(new ResourceLocation("enrich_with_katana", "no_se")));
}
