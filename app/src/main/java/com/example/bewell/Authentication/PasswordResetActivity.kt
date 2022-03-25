package com.example.bewell.Authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.example.bewell.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class PasswordResetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)

        val reset_password_button = findViewById<Button>(R.id.reset_password_button)

        reset_password_button.setOnClickListener {
            resetPassword()
        }
    }

    private fun resetPassword(){
        val reset_password_email = findViewById<TextInputEditText>(R.id.reset_password_email)
        val email = reset_password_email.text.toString()

        if (email.isEmpty()){
            reset_password_email.error = "The email cannot be empty!"
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            reset_password_email.error = "This email address is not valid."
            return
        }

        val auth = FirebaseAuth.getInstance()

        auth.sendPasswordResetEmail(email).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(this, "Please check your e-mail.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }else{
                val message = it.exception?.message
                Toast.makeText(this, "Error: $message", Toast.LENGTH_SHORT).show()
            }
        }
    }
}