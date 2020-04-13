package com.shadowmanu.terrakova.objects.advancements

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.shadowmanu.terrakova.TerraKova
import net.minecraft.advancements.criterion.AbstractCriterionTrigger
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.player.ServerPlayerEntity
import net.minecraft.util.JSONUtils
import net.minecraft.util.ResourceLocation

class FamiliarizationTrigger :
  AbstractCriterionTrigger<FamiliarizationInstance>() {
  companion object {
    val ID = ResourceLocation(TerraKova.MOD_ID, "familiarity_changed")
  }

  override fun getId() = FamiliarizationTrigger.ID

  override fun deserializeInstance(
    json: JsonObject,
    context: JsonDeserializationContext
  ): FamiliarizationInstance {
    val animal: JsonElement? = json.get("animal")
    val familiarity: JsonElement? = json.get("familiarity")

    val location = if (animal != null && !animal.isJsonNull)
      ResourceLocation(JSONUtils.getString(animal, "animal"))
    else
      null

    val minimum = if (familiarity != null && !familiarity.isJsonNull)
      JSONUtils.getFloat(familiarity, "familiarity")
    else
      0f

    return FamiliarizationInstance(location, minimum)
  }

  // TODO UPDATE animal type with IAnimalTFC
  fun trigger(
    player: ServerPlayerEntity,
    animal: AnimalEntity
  ) {
    // This function seems to call AbstractCriterionTrigger internal listeners
    // that satisfy the predicate
    this.func_227070_a_(player.advancements) { it.test(player, animal) }
  }
}
