package com.example.bewell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bewell.Utilities.setBottomNav

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setBottomNav(findViewById(R.id.bottom_navigation), this)

    }
}