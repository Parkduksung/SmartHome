package com.example.notcompose.ui.ext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.notcompose.ui.sensor.SensorActivity

fun AppCompatActivity.startSensorActivity(type : String){
    val intent = Intent(this, SensorActivity::class.java).apply {
        putExtra("key_type", type)
    }
    startActivity(intent)
}