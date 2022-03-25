package com.example.bewell.Authentication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import com.example.bewell.R
import com.example.bewell.Utilities.changeActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val button_reg = findViewById<Button>(R.id.button_reg)
        val already_have_account_text_view = findViewById<TextView>(R.id.already_have_account_text_view)
        val text_view_accept = findViewById<TextView>(R.id.text_view_accept)

        button_reg.setOnClickListener {
            preformRegistration()
        }

        already_have_account_text_view.setOnClickListener {
            changeActivity(this, LoginActivity::class.java)
        }
        text_view_accept.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/G1IbRujko-A"))
            startActivity(intent)
        }

    }
    private fun preformRegistration() {
        val auth = FirebaseAuth.getInstance()
        val email_reg = findViewById<TextInputEditText>(R.id.email_reg)
        val password_reg = findViewById<TextInputEditText>(R.id.password_reg)
        val repassword_reg = findViewById<TextInputEditText>(R.id.repassword_reg)
        val user_name_reg = findViewById<TextInputEditText>(R.id.user_name_reg)

        val email = email_reg.text.toString()
        val password = password_reg.text.toString()
        val confirmPassword = repassword_reg.text.toString()
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val userName = user_name_reg.text.toString()


        if (email.isEmpty()) {
            email_reg.error = "Email cannot be empty"
            return
        }
        if (userName.isEmpty()) {
            user_name_reg.error = "Username cannot be empty"
            return
        }
        if (password.isEmpty()) {
            password_reg.error = "Password cannot be empty"
            return
        }
        if (password.length <= 6) {
            password_reg.error = "The password has to be at least 7 character long"
            return
        }
        if (password != confirmPassword) {
            password_reg.error = "The given passwords are not the same"
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email_reg.error = "This email address is not valid"
            return
        }
        if (!checkBox.isChecked) {
            Toast.makeText(
                this,
                "You have to accept the General Terms and Conditions.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    user?.sendEmailVerification()?.addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this,
                                "Successfully created a user. Please check email for verification",
                                Toast.LENGTH_SHORT
                            ).show()
                            //createUserDB(email, userName)
                            changeActivity(this, LoginActivity::class.java)
                        } else {
                            Toast.makeText(
                                this,
                                task.exception?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }

    }

//    private fun createUserDB(email: String, userName: String) {
//        val uid = FirebaseAuth.getInstance().currentUser?.uid
//        val db = Firebase.firestore
//
//        val user: UserData = UserData(userName, email)
//
//        db.collection("Users")
//            .document(uid.toString())
//            .set(user)
//            .addOnSuccessListener {
//                Log.d("createUser", "DocumentSnapshot added with ID: $it")
//            }.addOnFailureListener { e->
//                Log.d("createUser", e.toString())
//            }
//    }
}