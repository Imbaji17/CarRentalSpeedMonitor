package com.carrental.speedmonitor.infrastructure.notifier

import com.carrental.speedmonitor.domain.model.Rental
import com.carrental.speedmonitor.domain.model.SpeedEvent

interface Notifier {
    suspend fun notifyRentalCompany(rental: Rental, event: SpeedEvent): Boolean
    suspend fun alertUser(userId: String, message: String): Boolean
}
