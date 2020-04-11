package com.shadowmanu.terrakova

import com.shadowmanu.terrakova.proxy.ClientProxy
import com.shadowmanu.terrakova.proxy.ServerProxy
import net.alexwells.kottle.FMLKotlinModLoadingContext
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.DistExecutor
import net.minecraftforge.fml.common.Mod
import java.util.function.Supplier

@Suppress("MemberVisibilityCanBePrivate")
@Mod(TerraKova.MOD_ID)
object TerraKova {
  const val MOD_ID = "terrakova"

  private val proxy = DistExecutor.runForDist(
    { Supplier { ClientProxy() } },
    { Supplier { ServerProxy() } }
  )

  init {
    FMLKotlinModLoadingContext.get().modEventBus.register(proxy)
    MinecraftForge.EVENT_BUS.register(proxy)
  }
}
