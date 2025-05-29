package com.carrental.speedmonitor.domain.model

data class SpeedEvent(
    val rentalId: String,
    val timestamp: Long,
    val speed: Double
)
