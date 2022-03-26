package com.example.bewell.Database

import android.util.Log
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class Journal constructor() : DataHandler(){
    private var timestamp = ""
        get() = field
        set(value) {
            field = value
        }
    private var data: String = ""
        get() = field
        set(value) {
            field = value
        }


    constructor(data: String): this(){
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd/HH:mm:ss")
        df.timeZone = TimeZone.getTimeZone("gmt")

        this.timestamp =  df.format(Date())
        this.data = data
    }


    override fun uploadToFirebase() {
        val data = hashMapOf(
            "journal" to data
        )
        val id = timestamp.split("/")[0]
        db.collection(outerCollection).document(uid.toString()).collection("Journal").document(id)
            .set(data).addOnFailureListener { e ->
                throw Exception("Upload failed (Journal): ${e.message}")
            }
    }
}