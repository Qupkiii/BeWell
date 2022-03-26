package com.example.bewell.Form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.bewell.Database.Journal
import com.example.bewell.R
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class FormMoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

//        val uid = FirebaseAuth.getInstance().currentUser?.uid
//        val j = Journal(uid.toString(), 30)
//        j.printTest()

        val finishButton = findViewById<Button>(R.id.finish_button)

        val radioGroup = findViewById<RadioGroup>(R.id.radios)
        finishButton.setOnClickListener {
            val selectedRadioButtonId: Int = radioGroup.checkedRadioButtonId
            Log.d("radio++", selectedRadioButtonId.toString())
            //selectedRadioButton = findViewById(selectedRadioButtonId)
            //val string: String = selectedRadioButton.text.toString()
        }
    }


}