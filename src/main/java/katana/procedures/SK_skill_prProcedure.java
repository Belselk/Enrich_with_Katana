package katana.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class SK_skill_prProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double r = 0;
		double vx = 0;
		double vy = 0;
		double vz = 0;
		double alpha = 0;
		double beta = 0;
		double count = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.PLAYERS, (float) 0.1, 10);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.PLAYERS, (float) 0.1, 10, false);
					}
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			r = 1;
			alpha = entity.getYRot();
			beta = entity.getXRot();
			count = 70;
			while (count > 0) {
				vx = x - r * Math.cos(Math.toRadians(beta)) * Math.sin(Math.toRadians(alpha));
				vy = (y + entity.getBbHeight() - 0.3) - r * Math.sin(Math.toRadians(beta));
				vz = z + r * Math.cos(Math.toRadians(beta)) * Math.cos(Math.toRadians(alpha));
				if (count == 60) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.CRIT, vx, vy, vz, 60, 0, 0, 0, 1);
				}
				world.addParticle(ParticleTypes.INSTANT_EFFECT, vx, vy, vz, 0, 0, 0);
				{
					final Vec3 _center = new Vec3(vx, vy, vz);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator == entity)
								&& !(entityiterator == (entity.getVehicle()))) {
							entityiterator.invulnerableTime = 0;
							entityiterator.hurt(((new EntityDamageSource("mob", entity)).bypassArmor()), (float) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 0.6));
							entityiterator.invulnerableTime = 0;
							entityiterator.hurt((new EntityDamageSource("mob", entity)), (float) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 0.5));
							{
								ItemStack _ist = itemstack;
								if (_ist.hurt(Mth.nextInt(RandomSource.create(), 0, (int) (2.5 - 0.5 * EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, itemstack))), RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
							count = 0;
							if (!world.isClientSide()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, new BlockPos(vx, vy, vz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS, 1, 1);
									} else {
										_level.playLocalSound(vx, vy, vz, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.PLAYERS, 1, 1, false);
									}
								}
							}
						}
					}
				}
				if (entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((r + 0.05))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getType() == HitResult.Type.BLOCK) {
					count = 0;
				}
				r = r + 0.1;
				count = count - 1;
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), (int) ((1 / ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).getValue()) * 30));
			}
		}
	}
}
