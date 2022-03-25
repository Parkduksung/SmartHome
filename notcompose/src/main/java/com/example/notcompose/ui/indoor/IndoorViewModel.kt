package com.example.notcompose.ui.indoor

import android.app.Application
import com.example.notcompose.base.BaseViewModel
import com.example.notcompose.constant.SensorType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IndoorViewModel @Inject constructor(app: Application) : BaseViewModel(app) {

    fun routeInnerSensor(type: SensorType) {
        viewStateChanged(type)
    }
}