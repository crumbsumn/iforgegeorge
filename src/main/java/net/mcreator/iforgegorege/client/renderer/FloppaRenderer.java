
package net.mcreator.iforgegorege.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.iforgegorege.entity.FloppaEntity;
import net.mcreator.iforgegorege.client.model.Modelcustom_model;

public class FloppaRenderer extends MobRenderer<FloppaEntity, LivingEntityRenderState, Modelcustom_model> {
	private FloppaEntity entity = null;

	public FloppaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(FloppaEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("i_forge_gorege:textures/entities/texture.png");
	}
}
