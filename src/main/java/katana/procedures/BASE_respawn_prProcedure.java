package katana.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import katana.network.EnrichWithKatanaModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BASE_respawn_prProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double e = 0;
		e = (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + (entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnrichWithKatanaModVariables.PlayerVariables())).extend_life;
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(e);
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
	}
}
