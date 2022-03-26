package com.example.bewell.Form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.bewell.Database.Form
import com.example.bewell.MainActivity
import com.example.bewell.R
import com.example.bewell.Utilities.changeActivity
import com.example.bewell.Utilities.setBottomNav
import kotlin.Exception

class FormActivity : AppCompatActivity() {

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

            val radioGroupViewIds: List<Int> = listOf(R.id.item_1, R.id.item_2, R.id.item_3,
                R.id.item_4, R.id.item_5, R.id.item_6, R.id.item_7, R.id.item_8, R.id.item_9,
                R.id.item_10, R.id.item_11, R.id.item_12, R.id.item_13)


            val answerPointPairs = LinkedHashMap<String, String>()
            var beckPointSum: Int = 0

            radioGroupViewIds.forEach { item ->
                val radioGroup = findViewById<RadioGroup>(item)
                val radioId: Int = radioGroup.getCheckedRadioButtonId()

                if (radioId != -1) {
                    val radioButton: RadioButton = findViewById<RadioButton>(radioId)
                    val radioText: String = radioButton.text as String

                    val beckPoint: Int = (radioId + 1) % 4

                    answerPointPairs[radioText] = beckPoint.toString()
                    beckPointSum += beckPoint
                }
            }

            val form = Form(answerPointPairs, beckPointSum)
            try {
                form.uploadToFirebase()
                changeActivity(this, MainActivity::class.java)
            }
            catch (e: Exception) {
                Log.d(FormActivity::class.java.simpleName, "Upload to firebase has failed ${e.message}")
            }
        }
    }
}