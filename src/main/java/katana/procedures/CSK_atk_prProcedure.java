package katana.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.ModList;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import katana.network.EnrichWithKatanaModVariables;

import katana.init.EnrichWithKatanaModMobEffects;
import katana.init.EnrichWithKatanaModItems;

public class CSK_atk_prProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double random = 0;
		if (0 == (entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnrichWithKatanaModVariables.PlayerVariables())).swing_cooltime) {
			if (!ModList.get().isLoaded("bettercombat")) {
				if (EnrichWithKatanaModItems.CSK_14.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()) {
					random = Mth.nextInt(RandomSource.create(), 1, 10);
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.OFF_HAND, true);
					world.addParticle(ParticleTypes.SWEEP_ATTACK,
							(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, entity)).getBlockPos().getX()),
							(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, entity)).getBlockPos().getY()),
							(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, entity)).getBlockPos().getZ()), 0, 0, 0);
					{
						ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
					if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()) : false) {
						if (1 <= (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()).getAmplifier() : 0)) {
							if (7 < random) {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, (y + entity.getBbHeight() - 1.3), z, 200, 3, 0.5, 3, 1);
								if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
									_entity.addEffect(new MobEffectInstance(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get(), 60, 1));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.step")), SoundSource.PLAYERS, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.step")), SoundSource.PLAYERS, 1, 1, false);
									}
								}
							}
						} else {
							if (7 < random) {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, (y + entity.getBbHeight() - 1.3), z, 200, 3, 0.5, 3, 1);
								if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
									_entity.addEffect(new MobEffectInstance(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get(), 100, 2));
							}
						}
					} else {
						if (7 < random) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.CRIT, x, (y + entity.getBbHeight() - 1.3), z, 200, 3, 0.5, 3, 1);
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get(), 140, 0));
						}
					}
				}
			}
			random = Mth.nextInt(RandomSource.create(), 1, 10);
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()) : false) {
				if (0 == (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()).getAmplifier() : 0)) {
					if (7 < random) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CRIT, x, (y + entity.getBbHeight() - 1.3), z, 200, 3, 0.5, 3, 1);
						if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get(), 100, 1));
					}
				} else if (1 == (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()) ? _livEnt.getEffect(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get()).getAmplifier() : 0)) {
					if (8 < random) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, (y + entity.getBbHeight() - 1.3), z, 200, 3, 0.5, 3, 1);
						if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get(), 60, 2));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.step")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.step")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
					}
				}
			} else {
				if (5 < random) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.CRIT, x, (y + entity.getBbHeight() - 1.3), z, 200, 3, 0.5, 3, 1);
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(EnrichWithKatanaModMobEffects.BERYLLIUM_POISON.get(), 140, 0));
				}
			}
			{
				double _setval = 5;
				entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.swing_cooltime = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
