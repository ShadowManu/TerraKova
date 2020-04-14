package com.shadowmanu.terrakova.api.types

import com.shadowmanu.terrakova.util.KBiConsumer
import net.minecraft.entity.LivingEntity
import net.minecraft.world.biome.Biome
import java.util.*
import java.util.function.BiConsumer

/**
 * Interface for creature spawning mechanics
 * TODO Missing world.classic.WorldEntitySpawnerTFC link
 */
interface ICreatureTFC {
  /**
   * Gets the random weight (1 in N chunks) to spawn this creature
   *
   * @param biome       the biome in chunk that is trying to spawn this creature
   * @param temperature the average temperature of this region
   * @param rainfall    the average rainfall of this region
   * @return 0 if can't spawn, 1 or more for how ofter this creature spawn in said biome
   */
  fun spawnWeight(
    biome: Biome?,
    temperature: Float,
    rainfall: Float
  ): Int

  /**
   * Returns the grouping rules (one or more) for spawn
   * Override this if you want your groups to have some form of rules applied to them
   * (ie for animals: Mother and children, one male and all female)
   *
   * @return Consumer method to apply rules to all individuals at once
   */
  val groupingRules: BiConsumer<List<LivingEntity>, Random>?
    get() = KBiConsumer { _: List<LivingEntity>, _: Random -> }

  /**
   * Returns the minimum group size (if not solo) this creature spawns in
   *
   * @return minimum number of individuals in one group spawn
   */
  val minGroupSize: Int
    get() = 1

  /**
   * Returns the maximum group size this creature spawns in
   *
   * @return maximum number of individuals in one group spawn
   */
  val maxGroupSize: Int
    get() = 1
}
