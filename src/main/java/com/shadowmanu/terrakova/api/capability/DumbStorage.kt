package com.shadowmanu.terrakova.api.capability

import net.minecraft.nbt.INBT
import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability

class DumbStorage<T> : Capability.IStorage<T> {
  override fun readNBT(
    capability: Capability<T>,
    instance: T,
    side: Direction,
    nbt: INBT?
  ) {
    // When reading do nothing
  }

  override fun writeNBT(
    capability: Capability<T>,
    instance: T,
    side: Direction
  ): INBT? {
    // When writing, return nothing
    return null
  }
}

