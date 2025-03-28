package net.mcreator.iforgegorege.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

public class SummonnutProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack pickaxe = ItemStack.EMPTY;
		double ecnahntLevel = 0;
		double enchantLevel = 0;
		double EnchtSize = 0;
		double i = 0;
		double j = 0;
		double k = 0;
		if (!entity.isShiftKeyDown()) {
			pickaxe = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
			EnchtSize = pickaxe.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("i_forge_gorege:nut"))));
			i = x - EnchtSize;
			for (int index0 = 0; index0 < (int) (EnchtSize * 2 + 1); index0++) {
				j = y - EnchtSize;
				for (int index1 = 0; index1 < (int) (EnchtSize * 2 + 1); index1++) {
					k = z - EnchtSize;
					for (int index2 = 0; index2 < (int) (EnchtSize * 2 + 1); index2++) {
						if (world.getBlockState(BlockPos.containing(i, j, k)).canOcclude() && pickaxe.isCorrectToolForDrops((world.getBlockState(BlockPos.containing(i, j, k))))
								&& world.getBlockState(BlockPos.containing(i, j, k)).getDestroySpeed(world, BlockPos.containing(i, j, k)) >= 0) {
							if (getEntityGameType(entity) == GameType.CREATIVE) {
								world.destroyBlock(BlockPos.containing(i, j, k), false);
							} else {
								{
									BlockPos _pos = BlockPos.containing(i, j, k);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(i, j, k), null);
									world.destroyBlock(_pos, false);
								}
								if (world instanceof ServerLevel _level) {
									pickaxe.hurtAndBreak(1, _level, null, _stkprov -> {
									});
								}
							}
						}
						k = k + 1;
					}
					j = j + 1;
				}
				i = i + 1;
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}
