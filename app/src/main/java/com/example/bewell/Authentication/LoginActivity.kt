package com.example.bewell.Authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bewell.MainActivity
import com.example.bewell.R
import com.example.bewell.Utilities.changeActivity
import com.google.firebase.auth.FirebaseAuth
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        if (user != null) {
            if(user.isEmailVerified) {
                changeActivity(this, MainActivity::class.java)
            }
        }
        val button_login = findViewById<Button>(R.id.button_login)
        val dont_have_account_textview = findViewById<TextView>(R.id.dont_have_account_textview)
        val reset_password = findViewById<TextView>(R.id.reset_password)


        button_login.setOnClickListener {
            preformLogin(auth)
        }

        dont_have_account_textview.setOnClickListener {
            changeActivity(this, RegistrationActivity::class.java)
        }

        reset_password.setOnClickListener {
            changeActivity(this, PasswordResetActivity::class.java)
        }
    }

    private fun preformLogin(auth: FirebaseAuth) {
        val email = findViewById<TextInputEditText>(R.id.email)
        val password = findViewById<TextInputEditText>(R.id.password)

        val emailText = email.text.toString()
        val passwordText = password.text.toString()

        if(emailText.isEmpty()){
            email.error = "The email cannot be empty!"
            return
        }

        if(passwordText.isEmpty()){
            password.error = "The password cannot be empty!"
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            email.error = "This email address is not valid."
            return
        }

        Log.d("Login", "attempt login with email and password")
        auth.signInWithEmailAndPassword(emailText, passwordText)
            .addOnCompleteListener{
                val user = auth.currentUser
                if (it.isSuccessful) {
                    if (user != null) {
                        if (user.isEmailVerified) {
                            Toast.makeText(
                                this,
                                "Login is successful",
                                Toast.LENGTH_SHORT
                            ).show()
                            changeActivity(this, MainActivity::class.java)
                        } else {
                            Toast.makeText(
                                this,
                                "Please verify your email address",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            this,
                            "Invalid email or password",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@addOnCompleteListener
                    }
                }
            }

    }
}