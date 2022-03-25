package com.example.notcompose.constant

import com.example.notcompose.base.ViewState

sealed class SensorType : ViewState {
    object InnerTemp : SensorType()
    object InnerHumidity : SensorType()
    object InnerGas : SensorType()
    object InnerDust : SensorType()
    object InnerLight : SensorType()
    object OuterTemp : SensorType()
    object OuterHumidity : SensorType()
    object OuterDust : SensorType()
    object OuterRain : SensorType()
}
