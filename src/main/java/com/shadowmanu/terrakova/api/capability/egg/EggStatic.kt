package com.shadowmanu.terrakova.api.capability.egg

import com.shadowmanu.terrakova.TerraKova
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.CapabilityManager

object EggStatic {
  @CapabilityInject(IEgg::class)
  lateinit var CAPABILITY: Capability<IEgg>

  val KEY = ResourceLocation(TerraKova.MOD_ID, "egg")

  fun register() {
    val token = IEgg::class.java
    val storage = EggStorage()
    val factory = { Egg() }

    CapabilityManager.INSTANCE.register(token, storage, factory)
  }
}
