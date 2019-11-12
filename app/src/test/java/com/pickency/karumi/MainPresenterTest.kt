package com.pickency.karumi

import org.junit.Assert
import org.junit.Test
import java.util.*

class MainPresenterTest {

    lateinit var presenter: MainPresenter

    var hideLoginCalled = false
    var hideLogoutCalled = false
    var showError = false

    @Test
    fun whenLoginSuccessLoginFormIsHidden() {
        presenter = givenAPresenter()
        presenter.onLoginButtonClicked("GALICIA", "LLOVIENDO")
        Assert.assertTrue(hideLoginCalled)
    }

    @Test
    fun whenLoginFailErrorMethodIsCalled() {
        presenter = givenAPresenter()
        presenter.onLoginButtonClicked("asd", "asd")
        Assert.assertTrue(showError)
    }

    @Test
    fun whenLogoutSuccessLogoutIsHidden() {
        presenter = givenAPresenter(FixedTimeClock(Date(200000000)))
        presenter.onLogoutButtonClicked()
        Assert.assertTrue(hideLogoutCalled)
    }

    @Test
    fun whenLogoutFailsLogoutIsNotHiddenAndErrorIsShown() {
        presenter = givenAPresenter(FixedTimeClock(Date(111111111)))
        presenter.onLogoutButtonClicked()
        Assert.assertTrue(showError)
        Assert.assertFalse(hideLogoutCalled)
    }

    private fun givenAPresenter(clock: Clock = FixedTimeClock(Date())): MainPresenter = MainPresenter(LogIn(), LogOut(clock), object : MainViewTranslator {
        override fun hideLogin() {
            hideLoginCalled = true
        }

        override fun hideLogout() {
            hideLogoutCalled = true
        }

        override fun showError(message: String) {
            showError = true
        }

    })
}