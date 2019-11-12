package com.pickency.karumi

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainPresenter(
    val logIn: LogIn, val logOut: LogOut, val view: MainViewTranslator, private val context: CoroutineContext = Dispatchers.Default
) : CoroutineScope by MainScope() {

    fun onLoginButtonClicked(user: String, pass: String) = launch {
        val loginResult = withContext(context) { logIn.login(user, pass) }
        if (loginResult) {
            view.hideLogin()
        } else {
            view.showError("Error en login")
        }
    }

    fun onLogoutButtonClicked() = launch {
        val logoutResult = withContext(context) { logOut.logout() }
        if (logoutResult) {
            view.hideLogout()
        } else {
            view.showError("Error en logout")
        }
    }
}

interface MainViewTranslator {
    fun hideLogin()
    fun hideLogout()
    fun showError(message: String)
}