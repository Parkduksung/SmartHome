package com.example.notcompose.data.repo

import com.example.notcompose.data.model.SensorData
import com.example.notcompose.util.Result

interface SensorRepository {
    fun getSensorData(callback: (Result<SensorData>) -> Unit)
}