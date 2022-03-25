package com.example.notcompose.ui.outdoor

import android.os.Bundle
import androidx.activity.viewModels
import com.example.notcompose.R
import com.example.notcompose.base.BaseActivity
import com.example.notcompose.base.ViewState
import com.example.notcompose.constant.SensorType
import com.example.notcompose.databinding.ActivityOutdoorBinding
import com.example.notcompose.ext.startSensorActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OutdoorActivity : BaseActivity<ActivityOutdoorBinding>(R.layout.activity_outdoor) {

    private val outerViewModel by viewModels<OutdoorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    /**
     * 뷰모델 초기화
     */
    private fun initViewModel() {
        binding.viewModel = outerViewModel
        outerViewModel.viewStateLiveData.observe(this) { viewState: ViewState? ->
            (viewState as? SensorType)?.let { onChangedInnerSensor(viewState) }
        }
    }

    /**
     * 상태에 따른 화면변화를 나타냄
     */
    private fun onChangedInnerSensor(viewState: SensorType) {
        when (viewState) {
            is SensorType.OuterTemp -> {
                startSensorActivity("outTemp")
            }

            is SensorType.OuterDust -> {
                startSensorActivity("outDust")
            }
            is SensorType.OuterHumidity -> {
                startSensorActivity("outHumidity")
            }
            is SensorType.OuterRain -> {
                startSensorActivity("outRain")
            }
        }
    }

}