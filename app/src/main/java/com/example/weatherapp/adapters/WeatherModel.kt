package com.example.weatherapp.adapters

data class WeatherModel(
    val city: String,
    val time: String,
    val condition: String,
    val currentTemp: String,
    val tempMax: String,
    val tempMin: String,
    val imgUrl: String,
    val hours: String,
)
