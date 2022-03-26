package com.example.bewell

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bewell.Database.Form
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get user uid.
        val uid = FirebaseAuth.getInstance().currentUser?.uid
        //If not logged in load



    }
}


