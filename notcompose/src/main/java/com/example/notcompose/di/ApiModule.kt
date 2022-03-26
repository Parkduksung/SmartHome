package com.example.notcompose.di

import com.example.notcompose.data.SensorApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private const val BASE_URL ="http://192.168.184.219/"

    @Singleton
    @Binds
    fun provideSensorApi(): SensorApi =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build()
            .create(SensorApi::class.java)

}