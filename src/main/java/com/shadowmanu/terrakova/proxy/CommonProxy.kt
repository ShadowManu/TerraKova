package com.shadowmanu.terrakova.proxy

import com.shadowmanu.terrakova.Registry
import com.shadowmanu.terrakova.api.capability.damage.DamageResistance
import net.minecraft.block.Block
import net.minecraft.inventory.container.ContainerType
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntityType
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent

@Suppress("UNUSED_PARAMETER")
abstract class CommonProxy {
  @SubscribeEvent
  fun commonSetup(event: FMLCommonSetupEvent) {
    DamageResistance.register()
  }

  @SubscribeEvent
  fun registerBlocks(event: RegistryEvent.Register<Block>) {
    Registry.blocks.forEach { event.registry.register(it) }
  }

  @SubscribeEvent
  fun registerTiles(event: RegistryEvent.Register<TileEntityType<*>>) {
    Registry.tiles.forEach { event.registry.register(it) }
  }

  @SubscribeEvent
  fun registerItems(event: RegistryEvent.Register<Item>) {
    Registry.items.forEach { event.registry.register(it) }
  }

  @SubscribeEvent
  fun registerContainers(event: RegistryEvent.Register<ContainerType<*>>) {
    Registry.containers.forEach { event.registry.register(it) }
  }
}
