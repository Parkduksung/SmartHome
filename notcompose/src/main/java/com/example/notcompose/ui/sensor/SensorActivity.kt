package com.example.notcompose.ui.sensor

import android.os.Bundle
import androidx.activity.viewModels
import com.example.notcompose.R
import com.example.notcompose.base.BaseActivity
import com.example.notcompose.base.ViewState
import com.example.notcompose.databinding.ActivitySensorBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SensorActivity : BaseActivity<ActivitySensorBinding>(R.layout.activity_sensor) {

    private val sensorViewModel by viewModels<SensorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    /**
     * 뷰모델 초기화
     */
    private fun initViewModel() {
        sensorViewModel.sensorTypeObservableField.set(intent.getStringExtra("key_type"))
        sensorViewModel.viewStateLiveData.observe(this) { viewState: ViewState? ->
            (viewState as? SensorViewState)?.let { onChangedSensorState(viewState) }
        }
    }

    /**
     * 상태에 따른 화면변화를 나타냄
     */
    private fun onChangedSensorState(viewState: SensorViewState) {
        when (viewState) {

        }
    }
}