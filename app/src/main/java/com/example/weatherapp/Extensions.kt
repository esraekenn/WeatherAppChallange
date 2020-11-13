package com.example.weatherapp

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun String.dateDoDay(): String {
    val inFormat = SimpleDateFormat("yyy-MM-dd")
    val date = inFormat.parse(this)
    val lang = Locale.getDefault().language
    return if (lang == "tr") {
        val outFormat = SimpleDateFormat("EEEE")
        outFormat.format(date)
    } else {
        val outFormat = SimpleDateFormat("EEEE", Locale.US)
        outFormat.format(date)
    }   }