package com.shadowmanu.terrakova.api.capability.egg

import net.minecraft.nbt.CompoundNBT
import net.minecraft.nbt.INBT
import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability

class EggStorage : Capability.IStorage<IEgg> {
  override fun readNBT(
    capability: Capability<IEgg>?,
    instance: IEgg?,
    side: Direction?,
    nbt: INBT?
  ) {
    if (nbt == null || instance == null) return

    val compound = nbt as CompoundNBT
    val hatchDay = compound.getLong("hatchDay")
    val entityNBT = compound.get("entityNBT") as CompoundNBT

    instance.fertilize(hatchDay, entityNBT)
  }

  override fun writeNBT(
    capability: Capability<IEgg>?,
    instance: IEgg?,
    side: Direction?
  ): INBT? {
    if (instance == null) return null
    val hatchDay = instance.hatchDay ?: return null
    val entityNBT = instance.entityNBT ?: return null

    val result = CompoundNBT()
    result.putLong("hatchDay", hatchDay)
    result.put("entityNBT", entityNBT)

    return result
  }
}
