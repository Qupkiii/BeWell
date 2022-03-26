package com.example.bewell

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.bewell.Utilities.setBottomNav


class HealthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health)

        setBottomNav(findViewById(R.id.bottom_navigation), this)
    }

    override fun onStart() {
        super.onStart()
        val whoCard: CardView = findViewById(R.id.who)
        val nihCard: CardView = findViewById(R.id.nih)
        val helpCard: CardView = findViewById(R.id.call_help)

        whoCard.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/news-room/fact-sheets/detail/depression"))
            startActivity(browserIntent)
        }
        nihCard.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nimh.nih.gov/health/topics/depression"))
            startActivity(browserIntent)
        }
        helpCard.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "116123"))
            startActivity(intent)
        }


    }
}