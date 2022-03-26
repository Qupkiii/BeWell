package com.example.bewell.Form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
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

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_1 ->
                    if (checked) {
                        // Pirates are the best
                    }
                R.id.radio_2 ->
                    if (checked) {
                        // Ninjas rule
                    }
            }
        }
    }
}