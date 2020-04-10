package com.shadowmanu.terrakova.api.capability.mana

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.text.StringTextComponent
import net.minecraftforge.event.entity.living.LivingFallEvent
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent
import net.minecraftforge.eventbus.api.SubscribeEvent

class EventHandler {
  @SubscribeEvent
  fun onPlayerLogsIn(event: PlayerEvent.PlayerLoggedInEvent) {
    val player = event.player
    val mana =
      player.getCapability(ManaProvider.CAPABILITY, null).orElse(null)

    val message = String.format(
      "Hello there, you have §7%d§r mana left.",
      mana.value
    )

    player.sendMessage(StringTextComponent(message))
  }

  @SubscribeEvent
  fun onPlayerSleep(event: PlayerSleepInBedEvent) {
    val player = event.player

    if (player.world.isRemote) return

    val mana = player
      .getCapability(ManaProvider.CAPABILITY)
      .orElse(null)

    mana.fill(50f)

    val message = String.format(
      "You refreshed yourself in the bed. You " +
        "received 50 mana, you have §7%d§r mana left.", mana.value
    )

    player.sendMessage(StringTextComponent(message))
  }

  @SubscribeEvent
  fun onPlayerFalls(event: LivingFallEvent) {
    val entity = event.entity

    if (entity.world.isRemote || entity !is PlayerEntity || event.distance < 3)
      return

    val mana = entity.getCapability(ManaProvider.CAPABILITY).orElse(null)

    val points = mana.value
    val cost = event.distance * 2

    if (points > cost) {
      mana.consume(cost)

      val message = String.format(
        "You absorbed fall damage. It costed " +
          "§7%d§r mana, you have §7%d§r mana left.",
        cost,
        mana.value
      )

      entity.sendMessage(StringTextComponent(message))

      event.isCanceled = true
    }
  }

  @SubscribeEvent
  fun onPlayerClone(event: PlayerEvent.Clone) {
    val player = event.player
    val mana = player.getCapability(ManaProvider.CAPABILITY, null).orElse(null)
    val oldMana = event.original.getCapability(ManaProvider.CAPABILITY, null)
      .orElse(null)

    mana.set(oldMana.value)
  }
}
