package com.example.notcompose.data.source.remote

import com.example.notcompose.data.LoginResult
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
            override fun onResponse(
                call: Call<SensorResponse>,
                response: Response<SensorResponse>
            ) {
                response.body()?.let { callback(Result.Success(it)) }
            }

            override fun onFailure(call: Call<SensorResponse>, t: Throwable) {
                callback(Result.Error(Exception(t)))
            }
        })
    }

    override fun getResult(callback: (Boolean) -> Unit) {
        sensorApi.getResult("seongho").enqueue(object : Callback<LoginResult> {
            override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
                response.body()?.let {
                    callback.invoke(it.success)
                }
            }

            override fun onFailure(call: Call<LoginResult>, t: Throwable) {
                callback.invoke(false)
            }
        })
    }
}