package com.shadowmanu.terrakova.api.capability.mana

import com.shadowmanu.terrakova.TerraKova
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.ResourceLocation
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.eventbus.api.SubscribeEvent

class CapabilityHandler {
  private val location = ResourceLocation(TerraKova.MOD_ID, "mana")

  @SubscribeEvent
  fun attachCapability(event: AttachCapabilitiesEvent<Entity>) {
    if (event.`object` !is PlayerEntity) return

    event.addCapability(location, ManaProvider())
  }
}
