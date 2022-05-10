package com.example.notcompose.ui.sensor

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import com.example.notcompose.R
import com.example.notcompose.base.BaseActivity
import com.example.notcompose.base.ViewState
import com.example.notcompose.data.model.ChartDataItem
import com.example.notcompose.databinding.ActivitySensorBinding
import com.github.mikephil.charting.charts.LineChart
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

    lateinit var lineChart: LineChart

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
            is SensorViewState.GetSensorData -> {
            }

            is SensorViewState.GetSensorDataList -> {
                lineChart(viewState.data)
            }

        }
    }

    private fun lineChart(
        chartItem: List<ChartDataItem>,
        displayName: String = ""
    ) {

        lineChart = findViewById(R.id.lineChart)

        val entries = ArrayList<Entry>()
        for (i in chartItem.indices) {
            entries.add(Entry(chartItem[i].valData, i))
        }

        val depenses = LineDataSet(entries, displayName).apply {
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

        val labels = ArrayList<String>()
        for (i in chartItem.indices) {
            labels.add(chartItem[i].lableData)
        }

        val xAxis = lineChart.xAxis
        xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM
            textSize = 8f
            setDrawGridLines(false)
        }

        val legend = lineChart.legend

        legend.setDrawInside(false)

        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(depenses as ILineDataSet)
        val data = LineData(labels, dataSets)
        lineChart.data = data
        lineChart.setDescription("")
        lineChart.invalidate()
    }

}
