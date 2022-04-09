package com.example.notcompose.ui.sensor

import android.app.Application
import androidx.databinding.ObservableField
import com.example.notcompose.base.BaseViewModel
import com.example.notcompose.data.repo.SensorRepository
import com.example.notcompose.ext.convertSensorTitle
import com.example.notcompose.ext.ioScope
import com.example.notcompose.ext.uiScope
import com.example.notcompose.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class SensorViewModel @Inject constructor(
    app: Application,
    private val sensorRepository: SensorRepository
) : BaseViewModel(app) {


    val sensorTypeObservableField = ObservableField<String>()


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
                                SensorViewState.GetSensorData(
                                    sensorTypeObservableField.get()!!.convertSensorTitle(),
                                    result.data.result[0].getData(
                                        sensorTypeObservableField.get() ?: ""
                                    ).toInt()
                                )
                            )
                        }

                        is Result.Error -> {
                            viewStateChanged(SensorViewState.Error("데이터를 가져올 수 없습니다."))
                        }

                    }
                }

                delay(RENEW_INTERVAL)
            }
        }
    }

    companion object {
        private const val RENEW_INTERVAL = 1000L
    }
}
