package com.shadowmanu.terrakova.api.capability.egg

import net.minecraft.nbt.CompoundNBT

interface IEgg {
  val hatchDay: Long?
  val entityNBT: CompoundNBT?
  val isFertile: Boolean
  fun fertilize(hatchDay: Long, entityNBT: CompoundNBT)
}
