package com.shadowmanu.terrakova.util.calendar

/**
 * Base class for time calculations, based on ticks.
 * You must provide a ticks function, so calls can be used without
 * parameters (or including parameters for optimizations).
 */
open class Time(val ticks: () -> Long) {
  /**
   * Total hours since beginning.
   */
  fun hours(ticks: Long = ticks()): Long = ticks / TICKS_IN_HOUR

  /**
   * Total days since beginning.
   */
  fun days(ticks: Long = ticks()): Long = ticks / TICKS_IN_DAY

  /**
   * Equivalent world time. Value range between [0, 24000)
   */
  fun worldTime(ticks: Long = ticks()): Long =
    (ticks - (6 * TICKS_IN_HOUR)) % TICKS_IN_DAY

  companion object {
    const val TICKS_IN_HOUR = 1000
    const val HOURS_IN_DAY = 24

    const val TICKS_IN_DAY = TICKS_IN_HOUR * HOURS_IN_DAY
    const val TICKS_IN_MINUTE = TICKS_IN_HOUR / 60f
  }
}
