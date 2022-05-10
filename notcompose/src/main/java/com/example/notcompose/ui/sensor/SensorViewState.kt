package com.example.notcompose.ui.sensor

import com.example.notcompose.base.ViewState
import com.example.notcompose.data.model.ChartDataItem

sealed class SensorViewState : ViewState {
    data class GetSensorData(val type: String, val data: Float) : SensorViewState()
    data class GetSensorDataList(val type: String, val data: List<ChartDataItem>) : SensorViewState()
    data class Error(val message: String) : SensorViewState()
}