package com.example.notcompose.ui.outdoor

import android.app.Application
import com.example.notcompose.base.BaseViewModel
import com.example.notcompose.constant.SensorType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OutdoorViewModel @Inject constructor(app: Application) : BaseViewModel(app) {

    fun routeOutSensor(type: SensorType) {
        viewStateChanged(type)
    }
}