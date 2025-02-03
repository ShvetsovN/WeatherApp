package com.example.weatherapp

data class DayItem(
    val city: String,
    val date: String,
    val tempMin: String,
    val tempMax: String,
    val conditionText: String,
    val conditionImgUrl: String,
)
