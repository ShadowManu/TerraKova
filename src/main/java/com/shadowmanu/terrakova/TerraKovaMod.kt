package com.shadowmanu.terrakova;

import com.shadowmanu.terrakova.proxy.CommonProxy
import net.alexwells.kottle.FMLKotlinModLoadingContext
import net.minecraftforge.fml.common.Mod

const val MOD_ID = "terrakova"

@Mod(MOD_ID)
object TerraKova {
    private val proxy = CommonProxy()

    init {
        FMLKotlinModLoadingContext.get().modEventBus.register(proxy)
    }
}
