package katana.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import katana.init.EnrichWithKatanaModMobEffects;

public class BASE_adrenaline_tick_prProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.ADRENALINE.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.ADRENALINE.get()).getDuration() : 0) % 13 == 0) {
			if (world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.PLAYERS,
								(float) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.ADRENALINE.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.ADRENALINE.get()).getDuration() : 0) * 0.02), 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.PLAYERS,
								(float) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.ADRENALINE.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.ADRENALINE.get()).getDuration() : 0) * 0.02), 1,
								false);
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.ADRENALINE.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.ADRENALINE.get()).getDuration() : 0) >= 35) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, 1, true, false));
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.ADRENALINE.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.ADRENALINE.get()).getDuration() : 0) >= 10) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, 0, true, false));
		}
	}
}
