package com.shadowmanu.terrakova.api.capability.damage

import com.shadowmanu.terrakova.TerraKova
import com.shadowmanu.terrakova.api.capability.NoopStorage
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.CapabilityManager

object DamageResistanceStatic {
  @CapabilityInject(IDamageResistance::class)
  lateinit var CAPABILITY: Capability<IDamageResistance>

  val KEY = ResourceLocation(TerraKova.MOD_ID, "damage_resistance")

  fun register() {
    val token = IDamageResistance::class.java
    val storage = NoopStorage<IDamageResistance>()
    val factory = { DamageResistance() }

    CapabilityManager.INSTANCE.register(token, storage, factory)
  }
}
