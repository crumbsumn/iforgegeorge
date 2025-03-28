package net.mcreator.iforgegorege.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class FlashlightRightClickedOnBloturnblocksintofglowstoneProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), Blocks.GLOWSTONE.defaultBlockState(), 3);
	}
}
