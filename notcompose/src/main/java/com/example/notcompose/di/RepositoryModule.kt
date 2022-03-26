package com.example.notcompose.di

import com.example.notcompose.data.repo.SensorRepository
import com.example.notcompose.data.repo.SensorRepositoryImpl
import com.example.notcompose.data.source.remote.SensorRemoteDataSource
import com.example.notcompose.data.source.remote.SensorRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindSensorRepository(sensorRepositoryImpl: SensorRepositoryImpl): SensorRepository

    @Singleton
    @Binds
    abstract fun bindSensorRemoteDataSource(sensorRemoteDataSourceImpl: SensorRemoteDataSourceImpl): SensorRemoteDataSource
}