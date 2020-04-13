package com.shadowmanu.terrakova.objects.advancements

import net.minecraft.advancements.criterion.CriterionInstance
import net.minecraft.entity.EntityType
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.player.ServerPlayerEntity
import net.minecraft.util.ResourceLocation

class FamiliarizationInstance(
  private val location: ResourceLocation?,
  private val minimum: Float
) : CriterionInstance(FamiliarizationTrigger.ID) {
  fun test(player: ServerPlayerEntity, animal: AnimalEntity): Boolean {
    return if (location != null && location != EntityType.getKey(animal.type))
      false
    else
    // TODO IMPLEMENT IAnimalTFC and fix this
      false
  }
}
