package katana.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import katana.init.EnrichWithKatanaModItems;

import katana.EnrichWithKatanaMod;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class DK_skill_prProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double consumption = 0;
		if (EnrichWithKatanaModItems.DIVINE_KATANA.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			consumption = 4;
			if ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) >= consumption) {
				if ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) >= consumption) {
					if (entity instanceof Player _player)
						_player.getFoodData().setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) - consumption));
				} else if ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) < consumption
						&& (entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) >= consumption) {
					consumption = consumption - (entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0);
					if (entity instanceof Player _player)
						_player.getFoodData().setSaturation(0);
					if (entity instanceof Player _player)
						_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - consumption));
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity)) {
							if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.UNDEAD : false) || entity.isCurrentlyGlowing()) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 75, 0));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1));
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 300, 0));
						}
					}
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 4, (float) 1.15);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 4, (float) 1.15, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ENTITY_EFFECT, x, y, z, 250, 3, 3, 3, 1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 500, 3, 3, 3, 0.4);
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 600);
				EnrichWithKatanaMod.queueServerWork(600, () -> {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("\u00A73| Cooldown Complete |"), true);
				});
			}
		}
	}
}
