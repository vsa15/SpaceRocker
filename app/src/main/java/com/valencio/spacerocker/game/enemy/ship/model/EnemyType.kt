package com.valencio.spacerocker.game.enemy.ship.model

import androidx.annotation.DrawableRes
import com.valencio.spacerocker.game.common.Once
import com.valencio.spacerocker.game.common.RepeatTime
import java.io.Serializable

sealed class EnemyType(val spawnRate: RepeatTime) : Serializable

data class RegularEnemyType(
    @DrawableRes val drawableId: Int,
    val width: Float,
    val height: Float,
    val hp: Float,
    val impactPower: Float,
    val formation: EnemyFormation,
    val xOffsetSpeed: Float,
    val yOffsetSpeed: Float,
    val enemySpawnRate: RepeatTime
) : EnemyType(spawnRate = enemySpawnRate)

object LevelOneBossType : EnemyType(spawnRate = Once)
object LevelTwoBossType : EnemyType(spawnRate = Once)