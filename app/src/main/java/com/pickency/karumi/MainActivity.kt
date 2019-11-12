package com.pickency.karumi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            if (LogIn().login(usernameEditText.text.toString(), userPassEditText.text.toString())) {
                loginSuccess()
            } else {
                showError("Login error")
            }
        }
        logoutButton.setOnClickListener {
            if (LogOut(SystemClock()).logout()) {
                hideLogout()
            } else {
                showError("Logout error")
            }
        }
    }

    fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    fun loginSuccess() {
        logoutButton.visibility = View.VISIBLE
        group.visibility = View.GONE
    }

    fun hideLogout() {
        group.visibility = View.VISIBLE
        logoutButton.visibility = View.GONE
    }
}
