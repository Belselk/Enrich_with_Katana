package katana.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class RP_used_prProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack Storage_item_1 = ItemStack.EMPTY;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = itemstack.getOrCreateTag().getDouble("spawnX");
		sy = itemstack.getOrCreateTag().getDouble("spawnY");
		sz = itemstack.getOrCreateTag().getDouble("spawnZ");
		if (Blocks.CAMPFIRE == (world.getBlockState(new BlockPos(sx, sy, sz))).getBlock() && (world.getBlockState(new BlockPos(sx, sy, sz))).getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _getbp9
				&& (world.getBlockState(new BlockPos(sx, sy, sz))).getValue(_getbp9) && (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
			{
				BlockPos _pos = new BlockPos(sx, sy, sz);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
			{
				Entity _ent = entity;
				_ent.teleportTo(sx, sy, sz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(sx, sy, sz, _ent.getYRot(), _ent.getXRot());
			}
			entity.fallDistance = 0;
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE);
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 600);
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("pr.enrich_with_katana.recall_potion.not_found").getString())), true);
		}
	}
}
