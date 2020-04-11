package com.shadowmanu.terrakova

import com.google.common.collect.ImmutableSet
import net.minecraft.block.Block
import net.minecraft.inventory.container.ContainerType
import net.minecraft.item.Item
import net.minecraft.tileentity.TileEntityType

object Registry {
  val blocks = ImmutableSet.of<Block>()

  val tiles = ImmutableSet.of<TileEntityType<*>>()

  val items = ImmutableSet.of<Item>()

  val containers = ImmutableSet.of<ContainerType<*>>()
}
