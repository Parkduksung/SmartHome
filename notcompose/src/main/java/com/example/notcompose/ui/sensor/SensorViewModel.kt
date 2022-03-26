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
                            result.data
                        }

                        is Result.Error -> {

                        }

                    }
                }

//                uiScope {
//                    viewStateChanged(
//                        SensorViewState.GetSensorData(
//                            sensorTypeObservableField.get()!!.convertSensorTitle(),
//                            ((20..40).random())
//                        )
//                    )
//                }

                delay(RENEW_INTERVAL)
            }
        }
    }

    companion object {
        private const val RENEW_INTERVAL = 1000L
    }
}
