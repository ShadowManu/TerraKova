package com.shadowmanu.terrakova.utils

import java.util.function.BiConsumer

class KBiConsumer<T, U>(
  private val lambda: (p0: T, p1: U) -> Unit
) : BiConsumer<T, U> {

  override fun accept(p0: T, p1: U) {
    lambda(p0, p1)
  }
}
