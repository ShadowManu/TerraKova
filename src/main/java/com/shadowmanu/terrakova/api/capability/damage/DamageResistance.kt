package com.shadowmanu.terrakova.api.capability.damage

import com.shadowmanu.terrakova.TerraKova
import com.shadowmanu.terrakova.api.capability.DumbStorage
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.CapabilityManager

data class DamageResistance(
  override val crushing: Float = 0f,
  override val piercing: Float = 0f,
  override val slashing: Float = 0f
) : IDamageResistance {

  companion object {
    @CapabilityInject(IDamageResistance::class)
    var CAPABILITY: Capability<IDamageResistance> = null!!
    val KEY = ResourceLocation(TerraKova.MOD_ID, "damage_resistance")

    fun register() {
      val token = IDamageResistance::class.java
      val storage = DumbStorage<IDamageResistance>()
      val factory = { DamageResistance() }

      CapabilityManager.INSTANCE.register(token, storage, factory)
    }
  }
}
