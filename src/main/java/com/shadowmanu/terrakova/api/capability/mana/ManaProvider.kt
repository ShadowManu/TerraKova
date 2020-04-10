package com.shadowmanu.terrakova.api.capability.mana

import net.minecraft.nbt.INBT
import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.ICapabilitySerializable
import net.minecraftforge.common.util.LazyOptional

class ManaProvider : ICapabilitySerializable<INBT> {
  companion object {
    @CapabilityInject(IMana::class)
    var CAPABILITY: Capability<IMana> = null!!
  }

  private val instance = CAPABILITY.defaultInstance!!

  // Interface Implementation

  override fun <T : Any?> getCapability(
    cap: Capability<T>,
    side: Direction?
  ): LazyOptional<T> {
    return if (cap === CAPABILITY)
      LazyOptional.of { instance as T }
    else
      LazyOptional.empty<T>()
  }

  override fun deserializeNBT(nbt: INBT?) {
    return CAPABILITY.storage.readNBT(CAPABILITY, instance, null, nbt)
  }

  override fun serializeNBT(): INBT? {
    return CAPABILITY.storage.writeNBT(CAPABILITY, instance, null)
  }
}
