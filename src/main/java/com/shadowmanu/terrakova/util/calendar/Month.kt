package com.shadowmanu.terrakova.util.calendar

/**
 * Months of the Year and related temperatures
 */
enum class Month(val temperatureModifier: Float) {
  JANUARY(66.5f),
  FEBRUARY(65.5f),
  MARCH(56f),
  APRIL(47.5f),
  MAY(38f),
  JUNE(29.5f),
  JULY(27f),
  AUGUST(29.5f),
  SEPTEMBER(38f),
  OCTOBER(47.5f),
  NOVEMBER(56f),
  DECEMBER(65.5f);

  companion object {
    /**
     * Returns the month given the numeric representation in the range [0, 12)
     */
    fun fromPosition(position: Int): Month = values()[position]
  }
}
