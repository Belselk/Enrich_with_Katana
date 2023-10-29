
package katana.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ActivationMobEffect extends MobEffect {
	public ActivationMobEffect() {
		super(MobEffectCategory.NEUTRAL, -65485);
	}

	@Override
	public String getDescriptionId() {
		return "effect.enrich_with_katana.activation";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
