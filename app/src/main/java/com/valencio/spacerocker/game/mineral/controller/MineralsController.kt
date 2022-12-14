package com.valencio.spacerocker.game.mineral.controller

import com.valencio.spacerocker.game.common.Millis
import com.valencio.spacerocker.game.mineral.model.Mineral
import java.util.*

class MineralsController(
    initialMinerals: List<Mineral>,
    private val updateMinerals: (List<Mineral>) -> Unit,
    private val updateMineralsEarnedTotal: (Int) -> Unit
) {

    private var minerals: List<Mineral> = initialMinerals

    fun addMinerals(xOffset: Float, yOffset: Float, width: Float, mineralAmount: Int) {
        val mineral = Mineral(
            xOffset = xOffset,
            yOffset = yOffset,
            width = width
        )
        minerals += mineral
        updateMinerals(minerals)
        updateMineralsEarnedTotal(mineralAmount)
    }

    val processMineralsId = UUID.randomUUID().toString()
    val processMineralsRepeatTime = Millis(5)
    fun processMinerals() {
        minerals.forEach {
            it.process()
            if (it.removed) minerals -= it
        }
        updateMinerals(minerals)
    }
}