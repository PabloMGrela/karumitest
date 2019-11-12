package com.pickency.karumi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainViewTranslator {
    private val presenter = MainPresenter(LogIn(), LogOut(SystemClock()), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            presenter.onLoginButtonClicked(user = usernameEditText.text.toString(), pass = userPassEditText.text.toString())
        }
        logoutButton.setOnClickListener {
            presenter.onLogoutButtonClicked()
        }
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideLogin() {
        logoutButton.visibility = View.VISIBLE
        group.visibility = View.GONE
    }

    override fun hideLogout() {
        group.visibility = View.VISIBLE
        logoutButton.visibility = View.GONE
    }
}
