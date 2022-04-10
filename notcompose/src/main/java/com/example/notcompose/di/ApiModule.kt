package com.example.notcompose.di

import com.example.notcompose.data.SensorApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    /**
     * 매번 ip 바꾸는 부분은 여기를 바꿔주시면 됩니다.
     */
    private const val BASE_URL = "http://172.20.10.4/"

    @Singleton
    @Provides
    fun provideSensorApi(): SensorApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(SensorApi::class.java)

}