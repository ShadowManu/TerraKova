package com.shadowmanu.terrakova.api.capability

import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.capabilities.Capability

interface ICapabilityStatic<T> {
  var CAPABILITY: Capability<T>
  val KEY: ResourceLocation
  fun register()
}
