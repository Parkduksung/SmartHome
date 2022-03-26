package com.example.notcompose.data.source.remote

import com.example.notcompose.data.model.SensorData
import com.example.notcompose.util.Result

interface SensorRemoteDataSource {
    fun getSensorData(callback: (Result<SensorData>) -> Unit)
}