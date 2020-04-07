package com.shadowmanu.terrakova;

import com.shadowmanu.terrakova.proxy.CommonProxy
import net.alexwells.kottle.FMLKotlinModLoadingContext
import net.minecraftforge.fml.common.Mod

@Suppress("MemberVisibilityCanBePrivate")
@Mod(TerraKova.MOD_ID)
object TerraKova {
    const val MOD_ID = "terrakova"

    private val proxy = CommonProxy()

    init {
        FMLKotlinModLoadingContext.get().modEventBus.register(proxy)
    }
}
