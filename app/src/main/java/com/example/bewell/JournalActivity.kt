package com.example.bewell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.bewell.Database.Form
import com.example.bewell.Database.Journal
import com.example.bewell.Utilities.changeActivity
import com.example.bewell.Utilities.setBottomNav
import com.google.android.material.textfield.TextInputEditText

class JournalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)
        setBottomNav(findViewById(R.id.bottom_navigation), this)

        val save_journal_b = findViewById<Button>(R.id.save_journal)
        val text = findViewById<TextInputEditText>(R.id.content)
        save_journal_b.setOnClickListener {
            val j = Journal(text.text.toString())
            try {
                j.uploadToFirebase()
                changeActivity(this, MainActivity::class.java)
            }catch (e: Exception){
                Log.d(JournalActivity::class.java.simpleName, e.message.toString())
            }
        }
    }
}