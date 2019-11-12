package com.pickency.karumi

import java.util.*

class LogIn {
    fun login(user: String, password: String): Boolean =
        user == "GALICIA" && password == "LLOVIENDO"
}

class LogOut(val clock: Clock) {
    fun logout(): Boolean = clock.now().time / 1000 % 2 == 0L
}

interface Clock {
    fun now() = Date()
}

class SystemClock : Clock {
    override fun now() = Date()
}