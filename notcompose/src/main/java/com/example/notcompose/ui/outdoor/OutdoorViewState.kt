package com.example.notcompose.ui.outdoor

import com.example.notcompose.base.ViewState
import com.example.notcompose.data.model.Result

sealed class OutdoorViewState : ViewState {
    data class GetSensorData(val data: Result) : OutdoorViewState()
}