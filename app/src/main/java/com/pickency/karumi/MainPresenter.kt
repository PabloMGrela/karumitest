package com.pickency.karumi

class MainPresenter(val logIn: LogIn, val logOut: LogOut, val view: MainViewTranslator) {
    fun onLoginButtonClicked(user: String, pass: String) {
        return if (logIn.login(user, pass)) {
            view.hideLogin()
        } else {
            view.showError("Error en login")
        }
    }

    fun onLogoutButtonClicked() {
        if (logOut.logout()) {
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