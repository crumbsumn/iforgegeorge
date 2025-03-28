package net.mcreator.iforgegorege.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class FlyProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		BlockState on = Blocks.AIR.defaultBlockState();
		if (entity instanceof Player _player) {
			_player.getAbilities().mayfly = true;
			_player.onUpdateAbilities();
		}
	}
}
