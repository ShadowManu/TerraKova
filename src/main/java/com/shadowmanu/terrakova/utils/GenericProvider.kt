package com.shadowmanu.terrakova.utils

import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.ICapabilityProvider
import net.minecraftforge.common.util.LazyOptional

class GenericProvider<I : Any?, C : I>(
  private val value: C,
  private val capability: Capability<I>
) : ICapabilityProvider {

  override fun <T : Any?> getCapability(
    cap: Capability<T>,
    side: Direction?
  ): LazyOptional<T> {
    return if (cap == capability)
      @Suppress("UNCHECKED_CAST")
      LazyOptional.of { value as T }
    else
      LazyOptional.empty()
  }
}

