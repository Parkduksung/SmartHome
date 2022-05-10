package com.example.notcompose.data.source.remote

import com.example.notcompose.data.model.SensorResponse
import com.example.notcompose.util.Result

interface SensorRemoteDataSource {
    fun getSensorData(callback: (Result<SensorResponse>) -> Unit)

    fun getResult(callback: (Boolean) -> Unit)
}