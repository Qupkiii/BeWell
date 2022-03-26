package com.example.bewell.Database

import android.util.Log
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.log


class Journal constructor() : DataHandler(){
    private var creationDate = ""
        get() = field
        set(value) {
            field = value
        }
    private var data: String = ""
        get() = field
        set(value) {
            field = value
        }
    private var score: Int = 0
        get() = field
        set(value) {
            field = value
        }


    constructor(data: String, score: Int): this(){
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd/HH:mm:ss")
        df.timeZone = TimeZone.getTimeZone("gmt")

        this.creationDate =  df.format(Date())
        this.data = data
        this.score = score
    }



    fun printTest(){
        Log.d("printTest", "$creationDate - $data - $score")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Journal

        if (creationDate != other.creationDate) return false
        if (data != other.data) return false
        if (score != other.score) return false

        return true
    }

    override fun hashCode(): Int {
        var result = creationDate.hashCode()
        result = 31 * result + data.hashCode()
        result = 31 * result + score
        return result
    }
}