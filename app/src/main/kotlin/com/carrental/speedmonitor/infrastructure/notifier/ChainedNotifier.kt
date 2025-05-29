package com.carrental.speedmonitor.infrastructure.notifier

import com.carrental.speedmonitor.domain.model.Rental
import com.carrental.speedmonitor.domain.model.SpeedEvent

class ChainedNotifier(
    private val primary: Notifier,
    private val fallback: Notifier
) : Notifier {

    override suspend fun notifyRentalCompany(rental: Rental, event: SpeedEvent): Boolean {
        val primarySuccess = primary.notifyRentalCompany(rental, event)
        if (primarySuccess) return true
        println("Primary notifier failed, trying fallback for company notification.")
        return fallback.notifyRentalCompany(rental, event)
    }

    override suspend fun alertUser(userId: String, message: String): Boolean {
        val primarySuccess = primary.alertUser(userId, message)
        if (primarySuccess) return true
        println("Primary notifier failed, trying fallback for user alert.")
        return fallback.alertUser(userId, message)
    }
}
