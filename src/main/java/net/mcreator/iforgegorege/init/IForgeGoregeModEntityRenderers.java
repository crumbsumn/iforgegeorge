
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.iforgegorege.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.iforgegorege.client.renderer.JellybeanRenderer;
import net.mcreator.iforgegorege.client.renderer.FloppaRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class IForgeGoregeModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(IForgeGoregeModEntities.JELLYBEAN.get(), JellybeanRenderer::new);
		event.registerEntityRenderer(IForgeGoregeModEntities.FLOPPA.get(), FloppaRenderer::new);
		event.registerEntityRenderer(IForgeGoregeModEntities.LEMINIGUN_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(IForgeGoregeModEntities.ROCKETLAUNCHER_PROJECTILE.get(), ThrownItemRenderer::new);
	}
}
