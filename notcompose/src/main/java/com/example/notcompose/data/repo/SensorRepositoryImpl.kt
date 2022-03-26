package com.example.notcompose.data.repo

import com.example.notcompose.data.model.SensorData
import com.example.notcompose.data.source.remote.SensorRemoteDataSource
import com.example.notcompose.util.Result
import javax.inject.Inject

class SensorRepositoryImpl @Inject constructor(private val sensorRemoteDataSource: SensorRemoteDataSource) :
    SensorRepository {
    override fun getSensorData(callback: (Result<SensorData>) -> Unit) {
        sensorRemoteDataSource.getSensorData(callback)
    }
}