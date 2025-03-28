
package net.mcreator.iforgegorege.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class SUNBlock extends Block {
	public SUNBlock(BlockBehaviour.Properties properties) {
		super(properties.instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.SLIME_BLOCK).strength(1f, 10f).noCollission());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}
