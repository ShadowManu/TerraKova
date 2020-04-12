package com.shadowmanu.terrakova.api.capability.egg

import com.shadowmanu.terrakova.TerraKova
import com.shadowmanu.terrakova.api.capability.ICapabilityStatic
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.CapabilityManager

object EggStatic : ICapabilityStatic<IEgg> {
  @CapabilityInject(IEgg::class)
  override lateinit var CAPABILITY: Capability<IEgg>

  override val KEY = ResourceLocation(TerraKova.MOD_ID, "egg")

  override fun register() {
    val token = IEgg::class.java
    val storage = EggStorage()
    val factory = { Egg() }

    CapabilityManager.INSTANCE.register(token, storage, factory)
  }
}
