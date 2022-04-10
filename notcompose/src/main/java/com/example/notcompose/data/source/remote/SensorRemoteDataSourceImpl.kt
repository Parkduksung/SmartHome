package com.example.notcompose.data.source.remote

import com.example.notcompose.data.SensorApi
import com.example.notcompose.data.model.SensorResponse
import com.example.notcompose.util.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class SensorRemoteDataSourceImpl @Inject constructor(private val sensorApi: SensorApi) :
    SensorRemoteDataSource {

    override fun getSensorData(callback: (Result<SensorResponse>) -> Unit) {
        sensorApi.getSensorData().enqueue(object : Callback<SensorResponse> {
            override fun onResponse(call: Call<SensorResponse>, response: Response<SensorResponse>) {
                response.body()?.let { callback(Result.Success(it)) }
            }

            override fun onFailure(call: Call<SensorResponse>, t: Throwable) {
                callback(Result.Error(Exception(t)))
            }
        })
    }
}