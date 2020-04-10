package com.shadowmanu.terrakova.proxy

import net.minecraft.block.Block
import net.minecraft.inventory.container.ContainerType
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntityType
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import org.apache.logging.log4j.LogManager

class CommonProxy {
    private val logger = LogManager.getLogger()

    @SubscribeEvent
    fun registerBlocks(event: RegistryEvent.Register<Block>) {
        logger.info("Hello from register block!")
        // Registry.blocks.forEach { event.registry.register(it) }
    }

    @SubscribeEvent
    fun registerTiles(event: RegistryEvent.Register<TileEntityType<*>>) {
        logger.info("Hello from register tiles!")
        // Registry.tiles.forEach { event.registry.register(it) }
    }

    @SubscribeEvent
    fun registerItems(event: RegistryEvent.Register<Item>) {
        logger.info("Hello from register items!")
        // Registry.items.forEach { event.registry.register(it) }
    }

    @SubscribeEvent
    fun registerContainers(event: RegistryEvent.Register<ContainerType<*>>) {
        logger.info("Hello from register containers!")
        // Registry.containers.forEach { event.registry.register(it) }
    }
}
