package com.example.notcompose.ui.indoor

import android.app.Application
import com.example.notcompose.base.BaseViewModel
import com.example.notcompose.constant.SensorType
import com.example.notcompose.data.repo.SensorRepository
import com.example.notcompose.ext.ioScope
import com.example.notcompose.ui.sensor.SensorViewModel
import com.example.notcompose.ui.sensor.SensorViewState
import com.example.notcompose.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class IndoorViewModel @Inject constructor(
    app: Application,
    private val sensorRepository: SensorRepository
) : BaseViewModel(app) {

    fun routeInnerSensor(type: SensorType) {
        viewStateChanged(type)
    }

    init {
        subscribeSensorData()
    }

    private fun subscribeSensorData() {
        ioScope {
            while (true) {
                sensorRepository.getSensorData { result ->
                    when (result) {
                        is Result.Success -> {
                            viewStateChanged(
                                IndoorViewState.GetSensorData(
                                    result.data.result[0]
                                )
                            )
                        }

                        is Result.Error -> {
                            viewStateChanged(SensorViewState.Error("데이터를 가져올 수 없습니다."))
                        }

                    }
                }

                delay(SensorViewModel.RENEW_INTERVAL)
            }
        }
    }
}