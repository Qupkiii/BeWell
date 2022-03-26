package com.example.bewell.Form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bewell.Database.Journal
import com.example.bewell.R
import com.google.firebase.auth.FirebaseAuth

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

//        val uid = FirebaseAuth.getInstance().currentUser?.uid
//        val j = Journal(uid.toString(), 30)
//        j.printTest()
    }
}