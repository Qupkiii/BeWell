package com.example.bewell.Form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import com.example.bewell.R
import com.example.bewell.Utilities.setBottomNav

class FormMoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        setBottomNav(findViewById(R.id.bottom_navigation), this)

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