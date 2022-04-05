package com.example.notcompose.data

import com.example.notcompose.data.model.SensorResponse
import retrofit2.Call
import retrofit2.http.GET

interface SensorApi {

    @GET("inside.php")
    fun getSensorData(): Call<SensorResponse>
}