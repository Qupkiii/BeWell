package com.example.bewell

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bewell.Utilities.setBottomNav

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBottomNav(findViewById(R.id.bottom_navigation), this)



    }
}


