package com.example.bewell.Utilities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

fun <T : AppCompatActivity> changeActivity(context: Context, nextActivity: Class<T>, message: String? = null) {
    val intent = Intent(context, nextActivity).apply {
        if (message != null) {
            putExtra(nextActivity.simpleName, message)
        }
    }
    ContextCompat.startActivity(context, intent, null)
}



