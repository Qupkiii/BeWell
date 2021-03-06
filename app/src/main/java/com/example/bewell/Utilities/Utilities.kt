package com.example.bewell.Utilities

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.bewell.Authentication.LoginActivity
import com.example.bewell.Form.FormActivity
import com.example.bewell.HealthActivity
import com.example.bewell.MainActivity
import com.example.bewell.R
import com.example.bewell.SettingsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

fun <T : AppCompatActivity> changeActivity(context: Context, nextActivity: Class<T>, message: String? = null) {
    val intent = Intent(context, nextActivity).apply {
        if (message != null) {
            putExtra(nextActivity.simpleName, message)
        }
    }
    ContextCompat.startActivity(context, intent, null)
}

fun setBottomNav (bottomNavigationView: BottomNavigationView, context: Context){
    bottomNavigationView.setOnItemSelectedListener() { item ->
        when(item.itemId) {
            R.id.home -> {
                changeActivity(context, MainActivity::class.java)
                true
            }
            R.id.start_form -> {
                changeActivity(context, FormActivity::class.java)
                true
            }
            R.id.health -> {
                changeActivity(context, HealthActivity::class.java)
                true
            }
            R.id.settings -> {
                changeActivity(context, SettingsActivity::class.java)
                true
            }
            else -> false
        }
    }
}

fun logOut(context: Context) {
    Firebase.auth.signOut()
    changeActivity(context, LoginActivity::class.java)
}




