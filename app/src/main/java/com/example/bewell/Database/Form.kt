package com.example.bewell.Database

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.LinkedHashMap

class Form constructor() : DataHandler() {
    private var timestamp = ""
        get() = field
        set(value) {
            field = value
        }
    private var score: Int = 0
        get() = field
        set(value) {
            field = value
        }
    var fields = LinkedHashMap<String, String>()

    constructor(fields: LinkedHashMap<String, String>, score: Int): this(){
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd/HH:mm:ss")
        df.timeZone = TimeZone.getTimeZone("gmt")

        this.timestamp =  df.format(Date())
        this.score = score
        this.fields = fields
    }

    override fun uploadToFirebase() {
        val data = hashMapOf(
            "point" to score,
            "data" to fields
        )
        val id = timestamp.split("/")[0]
        db.collection(outerCollection).document(uid.toString()).collection("Form").document(id)
            .set(data).addOnFailureListener { e ->
                throw Exception("Upload failed (Form): ${e.message}")
            }
    }

}