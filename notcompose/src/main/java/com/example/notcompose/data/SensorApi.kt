package com.example.notcompose.data

import com.example.notcompose.data.model.SensorResponse
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SensorApi {

    @GET("window.php")
    fun getSensorData(): Call<SensorResponse>

    @POST("http://115.145.175.57:10099/users")
    fun getResult(
        @Query("username") username: String
    ): Call<LoginResult>

}


data class LoginResult(
    @SerializedName("success")
    val success: Boolean
)