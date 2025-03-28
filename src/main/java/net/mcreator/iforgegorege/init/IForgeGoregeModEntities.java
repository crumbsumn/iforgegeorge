
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.iforgegorege.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.iforgegorege.entity.RocketlauncherProjectileEntity;
import net.mcreator.iforgegorege.entity.LeminigunProjectileEntity;
import net.mcreator.iforgegorege.entity.JellybeanEntity;
import net.mcreator.iforgegorege.entity.FloppaEntity;
import net.mcreator.iforgegorege.IForgeGoregeMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class IForgeGoregeModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, IForgeGoregeMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<JellybeanEntity>> JELLYBEAN = register("jellybean",
			EntityType.Builder.<JellybeanEntity>of(JellybeanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FloppaEntity>> FLOPPA = register("floppa",
			EntityType.Builder.<FloppaEntity>of(FloppaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<LeminigunProjectileEntity>> LEMINIGUN_PROJECTILE = register("leminigun_projectile",
			EntityType.Builder.<LeminigunProjectileEntity>of(LeminigunProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RocketlauncherProjectileEntity>> ROCKETLAUNCHER_PROJECTILE = register("rocketlauncher_projectile",
			EntityType.Builder.<RocketlauncherProjectileEntity>of(RocketlauncherProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(IForgeGoregeMod.MODID, registryname))));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		JellybeanEntity.init(event);
		FloppaEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(JELLYBEAN.get(), JellybeanEntity.createAttributes().build());
		event.put(FLOPPA.get(), FloppaEntity.createAttributes().build());
	}
}
