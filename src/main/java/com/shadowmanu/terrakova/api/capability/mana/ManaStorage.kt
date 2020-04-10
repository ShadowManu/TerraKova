package com.shadowmanu.terrakova.api.capability.mana

import net.minecraft.nbt.FloatNBT
import net.minecraft.nbt.INBT
import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability

class ManaStorage : Capability.IStorage<IMana> {
  override fun readNBT(
    capability: Capability<IMana>,
    instance: IMana,
    side: Direction,
    nbt: INBT?
  ) {
    instance.set((nbt as FloatNBT).float)
  }

  override fun writeNBT(
    capability: Capability<IMana>,
    instance: IMana,
    side: Direction
  ): INBT {
    return FloatNBT.valueOf(instance.getValue())
  }
}
