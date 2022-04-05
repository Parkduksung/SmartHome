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
)