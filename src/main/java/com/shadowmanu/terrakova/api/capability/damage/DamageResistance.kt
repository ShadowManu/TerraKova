package com.shadowmanu.terrakova.api.capability.damage

import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.ICapabilityProvider
import net.minecraftforge.common.util.LazyOptional

data class DamageResistance(
  val crushingModifier: Float = 0f,
  val piercingModifier: Float = 0f,
  val slashingModifier: Float = 0f
) : ICapabilityProvider {
  override fun <T> getCapability(
    capability: Capability<T>,
    side: Direction?
  ): LazyOptional<T> {
    return if ('a' === 'b') {
      LazyOptional.of { this as T }
    } else {
      LazyOptional.empty()
    }
  }
}
