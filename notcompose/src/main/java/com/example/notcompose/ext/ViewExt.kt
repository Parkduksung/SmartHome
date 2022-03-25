package com.example.notcompose.ext

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.notcompose.ui.sensor.SensorActivity
import com.google.android.material.textfield.TextInputLayout


fun AppCompatActivity.showToast(context: Context = this, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(context: Context = this.requireContext(), message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}


fun View.hideKeyboard(context: Context = this.context) {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(this.windowToken, 0)
}

fun TextInputLayout.showError(message: String) {
    error = message
    isErrorEnabled = true
}

fun TextInputLayout.hideError() {
    isErrorEnabled = false
}


fun AppCompatActivity.startSensorActivity(type: String) {
    val intent = Intent(this, SensorActivity::class.java).apply {
        putExtra("key_type", type)
    }
    startActivity(intent)
}

fun String.convertSensorTitle(): String =
    when (this) {
        "innerTemp" -> {
            "내부 온도"
        }

        "innerDust" -> {
            "내부 미세먼지"
        }

        "innerLight" -> {
            "내부 조도"
        }

        "innerHumidity" -> {
            "내부 습도"
        }

        "innerGas" -> {
            "내부 가스"
        }

        "outTemp" -> {
            "외부 온도"
        }

        "outDust" -> {
            "외부 미세먼지"
        }
        "outHumidity" -> {
            "외부 습도"
        }
        "outRain" -> {
            "외부 빗물"
        }

        else -> {
            "오류"
        }
    }

