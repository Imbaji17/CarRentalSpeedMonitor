package com.carrental.speedmonitor.presentation.viewmodel

import com.carrental.speedmonitor.domain.usecase.ProcessSpeedEventUseCase
import com.carrental.speedmonitor.domain.model.SpeedEvent

class SpeedMonitorViewModel(
    private val useCase: ProcessSpeedEventUseCase
) {
    suspend fun onSpeedEvent(event: SpeedEvent) {
        useCase(event)
    }
}
