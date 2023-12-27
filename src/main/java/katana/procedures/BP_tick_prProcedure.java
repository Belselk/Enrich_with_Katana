package katana.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;

import katana.init.EnrichWithKatanaModMobEffects;

public class BP_tick_prProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (0 == (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()).getAmplifier() : 0)) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()).getDuration() : 0) % 30 == 0) {
				entity.invulnerableTime = 0;
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("Beryllium poison").bypassArmor(), 1);
			}
		} else if (1 == (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()).getAmplifier() : 0)) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()).getDuration() : 0) % 20 == 0) {
				entity.invulnerableTime = 0;
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("Beryllium poison").bypassArmor(), 2);
			}
		} else if (2 == (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()).getAmplifier() : 0)) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()).getDuration() : 0) % 10 == 0) {
				entity.invulnerableTime = 0;
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("Beryllium poison").bypassArmor(), 3);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1, 0));
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1, 20));
		}
		entity.invulnerableTime = 0;
	}
}
