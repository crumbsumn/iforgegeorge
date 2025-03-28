
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.iforgegorege.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.iforgegorege.client.gui.IphoneGUIScreen;
import net.mcreator.iforgegorege.client.gui.BeanselectScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class IForgeGoregeModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(IForgeGoregeModMenus.IPHONE_GUI.get(), IphoneGUIScreen::new);
		event.register(IForgeGoregeModMenus.BEANSELECT.get(), BeanselectScreen::new);
	}
}
