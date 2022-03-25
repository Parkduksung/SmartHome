package com.example.notcompose.ui.indoor

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.notcompose.R
import com.example.notcompose.base.BaseActivity
import com.example.notcompose.base.ViewState
import com.example.notcompose.constant.SensorType
import com.example.notcompose.databinding.ActivityIndoorBinding
import com.example.notcompose.ui.ext.startSensorActivity
import com.example.notcompose.ui.sensor.SensorActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IndoorActivity : BaseActivity<ActivityIndoorBinding>(R.layout.activity_indoor) {

    private val innerViewModel by viewModels<IndoorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    /**
     * 뷰모델 초기화
     */
    private fun initViewModel() {
        binding.viewModel = innerViewModel
        innerViewModel.viewStateLiveData.observe(this) { viewState: ViewState? ->
            (viewState as? SensorType)?.let { onChangedInnerSensor(viewState) }
        }
    }

    /**
     * 상태에 따른 화면변화를 나타냄
     */
    private fun onChangedInnerSensor(viewState: SensorType) {
        when (viewState) {
            is SensorType.InnerTemp -> {
                startSensorActivity("innerTemp")
            }

            is SensorType.InnerDust -> {
                startSensorActivity("innerDust")
            }
            is SensorType.InnerLight -> {
                startSensorActivity("innerLight")
            }
            is SensorType.InnerHumidity -> {
                startSensorActivity("innerHumidity")
            }
            is SensorType.InnerGas -> {
                startSensorActivity("innerGas")
            }

        }
    }

}