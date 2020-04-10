package com.shadowmanu.terrakova.api.capability.mana

interface IMana {
  fun consume(points: Float)
  fun fill(points: Float)
  fun set(points: Float)
  val value: Float
}
