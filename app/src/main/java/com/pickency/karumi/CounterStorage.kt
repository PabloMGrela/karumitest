package com.pickency.karumi

import android.content.Context

class CounterStorage(private val context: Context) {

    fun save(counter: Int) {
        val sp = context.getSharedPreferences("myAppSP", Context.MODE_PRIVATE)
        with(sp.edit()) {
            putInt("counter", counter)
            commit()
        }
    }

    fun getCounter(): Int? {
        val sp = context.getSharedPreferences("myAppSP", Context.MODE_PRIVATE)
        return if (sp.contains("counter")) {
            sp.getInt("counter", 0)
        } else null
    }

    fun clear() {
        val sp = context.getSharedPreferences("myAppSP", Context.MODE_PRIVATE)
        sp.edit().clear().apply()
    }

}