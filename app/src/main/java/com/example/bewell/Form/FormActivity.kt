package com.example.bewell.Form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bewell.Database.FirstForm
import com.example.bewell.Database.Form
import com.example.bewell.Database.Journal
import com.example.bewell.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.Exception
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd/HH:mm:ss")
        df.timeZone = TimeZone.getTimeZone("gmt")

        val emails: List<String> = listOf("test@gmail.com", "test2@gmail.com")
        val data = hashMapOf(
            "fName" to "Elek",
            "lName" to "Test",
            "dateOfBirth" to "1998-12-06",
            "conditionScore" to "50",
            "doctorEmail" to "doctor@gmail.com",
            "contactEmail" to emails,
            "dateOfFristTest" to df.format(Date())
        )

        val formData = LinkedHashMap<String, String>()
        formData["first"] = "first test data"
        formData["second"] = "2 test data"

        try {
            val journal: Journal = Journal("Test data test daata! asdasdasd")
            journal.uploadToFirebase()
            journal.userDataUpload(data)
            val form: Form = Form(formData, 30)
            form.uploadToFirebase()
            val firstform: FirstForm = FirstForm(formData, 30)
            firstform.uploadToFirebase()
        } catch (e: Exception) {
            Log.d("testmap", e.message.toString())
        }

    }
}