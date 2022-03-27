package com.example.bewell

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.bewell.Utilities.changeActivity
import com.example.bewell.Utilities.setBottomNav

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBottomNav(findViewById(R.id.bottom_navigation), this)

        val open_journal_b = findViewById<Button>(R.id.open_journal)
        open_journal_b.setOnClickListener {
            changeActivity(this, JournalActivity::class.java)
        }

    }
}


