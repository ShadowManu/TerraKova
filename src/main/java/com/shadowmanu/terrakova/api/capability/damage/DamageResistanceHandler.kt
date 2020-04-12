package com.shadowmanu.terrakova.api.capability.damage

import com.shadowmanu.terrakova.utils.GenericProvider
import net.minecraft.entity.Entity
import net.minecraft.entity.monster.*
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.eventbus.api.SubscribeEvent

class DamageResistanceHandler {
  @SubscribeEvent
  fun attachCapability(event: AttachCapabilitiesEvent<Entity>) {
    val resistance = when (event.`object`) {
      is CreeperEntity -> DamageResistance(+20f, -20f, 0f)
      is SkeletonEntity -> DamageResistance(-20f, Float.POSITIVE_INFINITY, 20f)
      is StrayEntity -> DamageResistance(-20f, Float.POSITIVE_INFINITY, 20f)
      is EndermanEntity -> DamageResistance(-10f, -10f, -10f)
      is ZombieEntity -> DamageResistance(+20f, 0f, -20f)
      else -> null
    } ?: return

    event.addCapability(
      DamageResistanceStatic.KEY,
      GenericProvider(resistance, DamageResistanceStatic.CAPABILITY)
    )
  }
}
