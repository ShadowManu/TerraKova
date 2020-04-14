package com.shadowmanu.terrakova.util.calendar

/**
 * Considers month duration for time calculations.
 * You must provide a daysPerMonth function, so calls can be used without
 * parameters (or including parameters for optimizations).
 */
class FormattedTime(
  ticks: () -> Long,
  val daysPerMonth: () -> Long
) : Time(ticks) {

  /**
   * Ticks in a Month, which depends on daysPerMonth.
   */
  private fun ticksInMonth(daysPerMonth: Long = daysPerMonth()) =
    TICKS_IN_DAY * daysPerMonth

  /**
   * Total months since the beginning.
   */
  fun months(ticks: Long = ticks(), daysPerMonth: Long = daysPerMonth()): Long =
    ticks / (daysPerMonth * TICKS_IN_DAY)

  /**
   * Total years since the beginning.
   */
  fun years(ticks: Long = ticks(), daysPerMonth: Long = daysPerMonth()): Long =
    1000 + (ticks / (12 * daysPerMonth * TICKS_IN_DAY))

  /**
   * Current minute fraction of the running time.
   */
  fun minute(ticks: Long = ticks()): Int =
    ((ticks % TICKS_IN_HOUR) / TICKS_IN_MINUTE).toInt()

  /**
   * Current hour fraction of the running time.
   */
  fun hour(ticks: Long = ticks()): Int =
    ((ticks % TICKS_IN_DAY) / TICKS_IN_HOUR).toInt()

  /**
   * Current day fraction of the running time.
   */
  fun day(ticks: Long = ticks(), daysPerMonth: Long = daysPerMonth()): Int =
    1 + ((ticks % ticksInMonth(daysPerMonth)) / TICKS_IN_DAY).toInt()

  /**
   * Current month fraction of the running time.
   */
  fun month(ticks: Long = ticks(), daysPerMonth: Long = daysPerMonth()): Month {
    val index = (ticks / ticksInMonth(daysPerMonth)).toInt() % 12
    return Month.fromPosition(index)
  }

  // There's 2 methods (getSeasonDisplayName, getDisplayDayName) that seem
  // to be proxy-sensitive.
  // TODO Investigate and probably implement in the proxy side
}
