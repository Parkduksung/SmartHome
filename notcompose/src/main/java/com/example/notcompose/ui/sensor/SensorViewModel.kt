package com.example.notcompose.ui.sensor

import android.app.Application
import androidx.databinding.ObservableField
import com.example.notcompose.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SensorViewModel @Inject constructor(
    app: Application,

    ) : BaseViewModel(app) {


    val sensorTypeObservableField = ObservableField<String>()
}