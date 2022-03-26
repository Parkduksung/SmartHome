package com.example.notcompose.data.source.remote

import com.example.notcompose.data.SensorApi
import com.example.notcompose.data.model.SensorData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import com.example.notcompose.util.Result
import java.lang.Exception

class SensorRemoteDataSourceImpl @Inject constructor(private val sensorApi: SensorApi) :
    SensorRemoteDataSource {

    override fun getSensorData(callback: (Result<SensorData>) -> Unit) {
        sensorApi.getSensorData().enqueue(object : Callback<SensorData> {
            override fun onResponse(call: Call<SensorData>, response: Response<SensorData>) {
                response.body()?.let { callback(Result.Success(it)) }
            }

            override fun onFailure(call: Call<SensorData>, t: Throwable) {
                callback(Result.Error(Exception(t)))
            }
        })
    }
}