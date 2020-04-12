package com.shadowmanu.terrakova.api.capability.damage

import com.shadowmanu.terrakova.TerraKova
import com.shadowmanu.terrakova.api.capability.ICapabilityStatic
import com.shadowmanu.terrakova.api.capability.NoopStorage
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.CapabilityManager

object DamageResistanceStatic : ICapabilityStatic<IDamageResistance> {
  @CapabilityInject(IDamageResistance::class)
  override lateinit var CAPABILITY: Capability<IDamageResistance>

  override val KEY = ResourceLocation(TerraKova.MOD_ID, "damage_resistance")

  override fun register() {
    val token = IDamageResistance::class.java
    val storage = NoopStorage<IDamageResistance>()
    val factory = { DamageResistance() }

    CapabilityManager.INSTANCE.register(token, storage, factory)
  }
}
