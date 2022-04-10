package com.example.notcompose.ui.sensor

import com.example.notcompose.base.ViewState

sealed class SensorViewState : ViewState {
    data class GetSensorData(val type: String, val data: Float) : SensorViewState()
    data class Error(val message: String) : SensorViewState()
}