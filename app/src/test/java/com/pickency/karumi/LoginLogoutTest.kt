package com.pickency.karumi

import org.junit.Assert
import org.junit.Test
import java.util.*

class LoginLogoutTest {

    @Test
    fun givenValidCredentialsUserCanLogin() {
        val result = LogIn().login("GALICIA", "LLOVIENDO")
        Assert.assertTrue(result)
    }

    @Test
    fun givenAnInvalidCredentialsUserCannotLogin() {
        Assert.assertFalse(LogIn().login("GAL", "LOL"))
    }

    @Test
    fun givenOddSecondLogoutIsSuccess() {
        val result = LogOut(FixedTimeClock(Date(2000000000))).logout()
        Assert.assertTrue(result)
    }

    @Test
    fun givenEvenSecondLogoutIsFail() {
        val result = LogOut(FixedTimeClock(Date(1111111111))).logout()
        Assert.assertFalse(result)
    }

}


class FixedTimeClock(val date: Date) : Clock {
    override fun now() = date
}