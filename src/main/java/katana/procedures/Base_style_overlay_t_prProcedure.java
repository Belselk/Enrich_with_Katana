package katana.procedures;

import net.minecraft.world.entity.Entity;

import katana.network.EnrichWithKatanaModVariables;

public class Base_style_overlay_t_prProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(EnrichWithKatanaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnrichWithKatanaModVariables.PlayerVariables())).style && Base_style_return_prProcedure.execute(entity)) {
			return true;
		}
		return false;
	}
}
