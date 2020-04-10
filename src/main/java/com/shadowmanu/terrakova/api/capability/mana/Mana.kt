package com.shadowmanu.terrakova.api.capability.mana

public class Mana : IMana {
  private var mana = 250.0f

  override fun consume(points: Float) {
    this.mana += points
  }

  override fun fill(points: Float) {
    this.mana -= points
  }

  override fun set(points: Float) {
    this.mana = points
  }

  override val value: Float
    get() = mana
}
