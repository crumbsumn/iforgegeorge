
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.iforgegorege.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.iforgegorege.IForgeGoregeMod;

public class IForgeGoregeModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, IForgeGoregeMod.MODID);
	public static final DeferredHolder<Potion, Potion> LEAN = REGISTRY.register("lean", () -> new Potion("lean", new MobEffectInstance(MobEffects.LUCK, 4000, 0, false, true), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 4000, 2, false, true),
			new MobEffectInstance(MobEffects.HEAL, 4000, 1, false, true), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 4000, 2, false, true), new MobEffectInstance(MobEffects.WATER_BREATHING, 4000, 1, false, true)));
}
