
package katana.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import katana.procedures.BP_tick_prProcedure;

public class BerylliumPoisonMobEffect extends MobEffect {
	public BerylliumPoisonMobEffect() {
		super(MobEffectCategory.HARMFUL, -6618968);
	}

	@Override
	public String getDescriptionId() {
		return "effect.enrich_with_katana.beryllium_poison";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BP_tick_prProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
