package com.example.notcompose.data.model

data class SensorResponse(
    val result: List<Result>
)

data class Result(
    val inside_dust: String,
    val inside_gas: String,
    val inside_hum: String,
    val inside_lux: String,
    val inside_tem: String,
    val outside_dust: String,
    val outside_hum: String,
    val outside_rain: String,
    val outside_tem: String
) {

    fun getData(type: String): String =
        when (type) {
            "innerTemp" -> {
                inside_tem
            }
            "innerDust" -> {
                inside_dust
            }
            "innerLight" -> {
                inside_lux
            }
            "innerHumidity" -> {
                inside_hum
            }
            "innerGas" -> {
                inside_gas
            }
            "outTemp" -> {
                outside_tem
            }
            "outDust" -> {
                outside_dust
            }
            "outHumidity" -> {
                outside_hum
            }
            "outRain" -> {
                outside_rain
            }
            else -> ""
        }

}