package com.pickency.karumi

class MainPresenter(val view: MainActivity) {
    fun onLoginButtonClicked(user: String, pass: String): Boolean {
        return if (user == "GALICIA" && pass == "LLOVIENDO") {
            view.loginSuccess()
            true
        } else {
            view.showError("Error en login")
            false
        }
    }

    fun onLogoutButtonClicked(currentTimeMillis: Long) {
        if (currentTimeMillis / 1000 % 2 == 0L) {
            view.hideLogout()
        } else {
            view.showError("Error en logout")
        }
    }

}