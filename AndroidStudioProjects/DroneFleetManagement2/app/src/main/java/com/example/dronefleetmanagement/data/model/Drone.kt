package com.example.dronefleetmanagement.data.model

data class Drone(
    val droneId: String,
    val droneName: String,
    val battery: Int,
    val status: String,
    val location: String,
    val altitude: String,
    val speed: String,
    val lastUpdated: String
)