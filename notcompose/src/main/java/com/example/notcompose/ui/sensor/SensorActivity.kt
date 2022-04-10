package com.example.notcompose.ui.sensor

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import com.example.notcompose.R
import com.example.notcompose.base.BaseActivity
import com.example.notcompose.base.ViewState
import com.example.notcompose.databinding.ActivitySensorBinding
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SensorActivity : BaseActivity<ActivitySensorBinding>(R.layout.activity_sensor) {

    private val sensorViewModel by viewModels<SensorViewModel>()
    private var floatTemp: Float? = 10f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        setup()
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
            is SensorViewState.GetSensorData -> {
                addEntry(viewState.type, viewState.data)
            }

        }
    }


    private fun setup() {
        val xAxis = binding.lineChart.xAxis

        xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM
            isGranularityEnabled = true
            textSize = 10f
            setDrawGridLines(false)
            granularity = 1f
            axisMinimum = 2f
        }

        binding.lineChart.apply {
            axisRight.isEnabled = true
            axisLeft.axisMaximum = 50f
            legend.apply {
                textSize = 15f
                verticalAlignment = Legend.LegendVerticalAlignment.TOP
                horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
                orientation = Legend.LegendOrientation.HORIZONTAL
                setDrawInside(false)
            }
        }

        val lineData = LineData()
        binding.lineChart.data = lineData
    }

    private fun addEntry(type: String, sensorData: Float) {
        val data = binding.lineChart.data

        data?.let {
            var set: ILineDataSet? = data.getDataSetByIndex(0)
            if (set == null) {
                set = createSet(type)
                data.addDataSet(set)
            }

            floatTemp = sensorData
            data.addEntry(Entry(set.entryCount.toFloat(), floatTemp!!), 0)
            data.notifyDataChanged()
            binding.lineChart.apply {
                notifyDataSetChanged()
                moveViewToX(data.entryCount.toFloat())
                setVisibleXRangeMaximum(8f)
                setPinchZoom(false)
                isDoubleTapToZoomEnabled = false
                description.text = ""
                setExtraOffsets(8f, 16f, 8f, 16f)
            }
        }
    }

    private fun createSet(type: String): ILineDataSet {
        val set = LineDataSet(null, type)
        set.apply {
            axisDependency = YAxis.AxisDependency.LEFT
            color = Color.DKGRAY
            setCircleColor(Color.GREEN)
            valueTextSize = 10f
            lineWidth = 2f
            circleRadius = 3f
            fillAlpha = 0
            fillColor = Color.GREEN
            highLightColor = Color.BLACK
            setDrawValues(true)
        }
        return set
    }
}
