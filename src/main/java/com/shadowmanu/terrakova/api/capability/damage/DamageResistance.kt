package com.shadowmanu.terrakova.api.capability.damage

data class DamageResistance(
  override val crushing: Float = 0f,
  override val piercing: Float = 0f,
  override val slashing: Float = 0f
) : IDamageResistance {}
