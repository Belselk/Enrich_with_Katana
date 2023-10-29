package katana.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import katana.network.EnrichWithKatanaModVariables;

import katana.init.EnrichWithKatanaModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BASE_activation_prProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EnrichWithKatanaModMobEffects.ACTIVATION.get()) : false) && (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.ACTIVATION.get())
				? _livEnt.getEffect(EnrichWithKatanaModMobEffects.ACTIVATION.get()).getDuration()
				: 0) != (entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnrichWithKatanaModVariables.PlayerVariables())).Activation) {
			{
				double _setval = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.ACTIVATION.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.ACTIVATION.get()).getDuration() : 0;
				entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Activation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EnrichWithKatanaModMobEffects.ACTIVATION.get()) : false)
				&& 1 < (entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnrichWithKatanaModVariables.PlayerVariables())).Activation) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(EnrichWithKatanaModMobEffects.ACTIVATION.get(),
						(int) (entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnrichWithKatanaModVariables.PlayerVariables())).Activation, 0));
		}
	}
}
