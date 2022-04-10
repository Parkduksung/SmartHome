package com.example.notcompose.ui.indoor

import com.example.notcompose.base.ViewState
import com.example.notcompose.data.model.Result

sealed class IndoorViewState : ViewState {
    data class GetSensorData(val data: Result) : IndoorViewState()
}