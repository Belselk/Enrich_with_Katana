package katana.procedures;

import net.minecraft.world.entity.Entity;

import katana.network.EnrichWithKatanaModVariables;

public class SK_swing_prProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnrichWithKatanaModVariables.PlayerVariables())).style) {
			{
				double _setval = 25;
				entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.swing_cooltime = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = 12;
				entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.swing_cooltime = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
