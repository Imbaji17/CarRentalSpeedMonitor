package com.carrental.speedmonitor.domain.model

data class Rental(
    val rentalId: String,
    val userId: String,
    val vehicleId: String,
    val maxAllowedSpeed: Double
)
