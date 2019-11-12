package com.pickency.karumi

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenter(val logIn: LogIn, val logOut: LogOut, val view: MainViewTranslator, val dispatcher: CoroutineDispatcher = Dispatchers.Unconfined) {
    fun onLoginButtonClicked(user: String, pass: String) {
        GlobalScope.launch(dispatcher) {
            if (logIn.login(user, pass)) {
                view.hideLogin()
            } else {
                view.showError("Error en login")
            }
        }
    }

    fun onLogoutButtonClicked() {
        GlobalScope.launch(dispatcher) {
            if (logOut.logout()) {
                view.hideLogout()
            } else {
                view.showError("Error en logout")
            }
        }
    }
}

interface MainViewTranslator {
    fun hideLogin()
    fun hideLogout()
    fun showError(message: String)
}