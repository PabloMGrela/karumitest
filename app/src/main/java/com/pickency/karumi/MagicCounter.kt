package com.pickency.karumi

import android.content.Context

class MagicCounter(context: Context) {

    private val counterStorage = CounterStorage(context)

    fun increment(random: Int): Int {
        val counter = counterStorage.getCounter() ?: 0
        val updatedCounter = if (random < 100) {
            counter + 1
        } else {
            counter + random
        }
        counterStorage.save(updatedCounter)
        return counterStorage.getCounter() ?: 0
    }

    fun decrement(): Int {
        val counter = counterStorage.getCounter() ?: 0
        counterStorage.save(counter - 1)
        return counterStorage.getCounter() ?: 0
    }
}