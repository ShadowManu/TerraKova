package com.shadowmanu.terrakova.api.capability.egg

import net.minecraft.nbt.CompoundNBT

class Egg : IEgg {
  private var day: Long = 0
  private var nbt: CompoundNBT? = null

  override val hatchDay = day
  override val entityNBT = nbt
  override val isFertile = day > 0 && nbt != null

  override fun fertilize(hatchDay: Long, entityNBT: CompoundNBT) {
    day = hatchDay
    nbt = entityNBT
  }
}
