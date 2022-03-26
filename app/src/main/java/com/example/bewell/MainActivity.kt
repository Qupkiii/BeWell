package com.example.bewell

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.bewell.Database.FirstForm
import com.example.bewell.Database.Form
import com.example.bewell.Database.Journal
import com.example.bewell.Form.FormActivity
import com.example.bewell.Utilities.changeActivity
import com.example.bewell.Utilities.setBottomNav
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.firebase.auth.FirebaseAuth
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.LinkedHashMap

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBottomNav(findViewById(R.id.bottom_navigation), this)


        //Upload Test
//        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd/HH:mm:ss")
//        df.timeZone = TimeZone.getTimeZone("gmt")
//
//        val emails: List<String> = listOf("test@gmail.com", "test2@gmail.com")
//        val data = hashMapOf(
//            "fName" to "Elek",
//            "lName" to "Test",
//            "dateOfBirth" to "1998-12-06",
//            "conditionScore" to "50",
//            "doctorEmail" to "doctor@gmail.com",
//            "contactEmail" to emails,
//            "dateOfFristTest" to df.format(Date())
//        )
//
//        val formData = LinkedHashMap<String, String>()
//        formData["first"] = "first test data"
//        formData["second"] = "2 test data"
//
//        try {
//            val journal: Journal = Journal("Test data test daata! asdasdasd")
//            val form: Form = Form(formData, 30)
//            val firstform: FirstForm = FirstForm(formData, 30)
//
////            journal.getFromFirebase("2022-03-26")
////            Log.d("responseData", journal.node.toString())
//            //Log.d("responseData", form.getFromFirebase("2022-03-26").toString())
//            //Log.d("responseData", firstform.getFromFirebase("2022-03-26").toString())
//        } catch (e: Exception) {
//            Log.d("responseData", e.message.toString())
//        }



    }
}


