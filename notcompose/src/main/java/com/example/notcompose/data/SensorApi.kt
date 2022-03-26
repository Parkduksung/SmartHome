package com.example.notcompose.data

import com.example.notcompose.data.model.SensorData
import retrofit2.Call
import retrofit2.http.GET

interface SensorApi {


    @GET("window.php")
    fun getSensorData(): Call<SensorData>
}