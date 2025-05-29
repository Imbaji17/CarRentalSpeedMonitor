package com.carrental.speedmonitor.domain.usecase

import com.carrental.speedmonitor.domain.model.Rental
import com.carrental.speedmonitor.domain.model.SpeedEvent
import com.carrental.speedmonitor.domain.repository.RentalRepository
import com.carrental.speedmonitor.infrastructure.notifier.Notifier

class ProcessSpeedEventUseCase(
    private val rentalRepository: RentalRepository,
    private val notifier: Notifier
) {
    suspend operator fun invoke(event: SpeedEvent) {
        val rental: Rental? = rentalRepository.getRental(event.rentalId)
        if (rental == null) {
            println("Rental not found for rentalId=${event.rentalId}")
            return
        }

        if (event.speed > rental.maxAllowedSpeed) {
            println("Overspeed detected! Speed=${event.speed} km/h, Limit=${rental.maxAllowedSpeed} km/h")
            val userAlertSuccess = notifier.alertUser(rental.userId, "Warning: You exceeded the speed limit!")
            val companyNotifySuccess = notifier.notifyRentalCompany(rental, event)

            if (!userAlertSuccess || !companyNotifySuccess) {
                println("One or more notifications failed. Consider retry mechanism.")
            }
        } else {
            println("Speed is within limit: ${event.speed} km/h")
        }
    }
}
