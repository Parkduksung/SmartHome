package com.example.notcompose.data.repo

import com.example.notcompose.data.model.SensorResponse
import com.example.notcompose.util.Result

interface SensorRepository {
    fun getSensorData(callback: (Result<SensorResponse>) -> Unit)

    fun getResult(callback: (Boolean) -> Unit)
}