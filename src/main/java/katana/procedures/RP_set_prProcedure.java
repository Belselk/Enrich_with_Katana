package katana.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class RP_set_prProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double count = 0;
		double cX = 0;
		double cY = 0;
		double cZ = 0;
		boolean c = false;
		count = 0;
		for (int index0 = 0; index0 < 4; index0++) {
			cX = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(count)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
			cY = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(count)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
			cZ = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(count)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
			if (Blocks.CAMPFIRE == (world.getBlockState(new BlockPos(cX, cY, cZ))).getBlock() && (world.getBlockState(new BlockPos(cX, cY, cZ))).getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _getbp6
					&& (world.getBlockState(new BlockPos(cX, cY, cZ))).getValue(_getbp6)) {
				itemstack.getOrCreateTag().putBoolean("cheak", true);
				break;
			}
			count = count + 1;
		}
		if (itemstack.getOrCreateTag().getBoolean("cheak") && Level.OVERWORLD == (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD)) {
			itemstack.getOrCreateTag().putDouble("spawnX", (cX + 0.5));
			itemstack.getOrCreateTag().putDouble("spawnY", (cY + 0.5));
			itemstack.getOrCreateTag().putDouble("spawnZ", (cZ + 0.5));
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("pr.enrich_with_katana.recall_potion.set").getString())), true);
		}
	}
}
