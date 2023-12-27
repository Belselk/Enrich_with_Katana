package katana.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import katana.network.EnrichWithKatanaModVariables;

import katana.init.EnrichWithKatanaModItems;

public class LC_used_prProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnrichWithKatanaModVariables.PlayerVariables())).extend_life < 10) {
			if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 3) {
				{
					double _setval = (entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnrichWithKatanaModVariables.PlayerVariables())).extend_life + 2;
					entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.extend_life = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() + 2));
				if (entity instanceof Player _player)
					_player.giveExperienceLevels(-(3));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, x, (y + 1), z, 150, 1, 1.5, 1, 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, (float) 1.5, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, (float) 1.5, (float) 1.2, false);
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7e \u30EC\u30D9\u30EB\u304C\u8DB3\u308A\u3066\u3044\u307E\u305B\u3093"), true);
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(EnrichWithKatanaModItems.LIFECRYSTAL.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7e \u6210\u9577\u4E0A\u9650\u306B\u9054\u3057\u3066\u3044\u307E\u3059"), true);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(EnrichWithKatanaModItems.LIFECRYSTAL.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
		}
	}
}
