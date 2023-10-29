
package katana.potion;

import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;

import katana.procedures.BASE_adrenaline_tick_prProcedure;

import com.mojang.blaze3d.vertex.PoseStack;

public class AdrenalineMobEffect extends MobEffect {
	public AdrenalineMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16745985);
	}

	@Override
	public String getDescriptionId() {
		return "effect.enrich_with_katana.adrenaline";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BASE_adrenaline_tick_prProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void initializeClient(java.util.function.Consumer<IClientMobEffectExtensions> consumer) {
		consumer.accept(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInInventory(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, PoseStack poseStack, int x, int y, int blitOffset) {
				return false;
			}

			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		});
	}
}
