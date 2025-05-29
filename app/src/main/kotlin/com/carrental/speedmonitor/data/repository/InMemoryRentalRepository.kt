package com.carrental.speedmonitor.data.repository

import com.carrental.speedmonitor.domain.model.Rental
import com.carrental.speedmonitor.domain.repository.RentalRepository
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class InMemoryRentalRepository : RentalRepository {
    private val rentals = mutableMapOf<String, Rental>()
    private val mutex = Mutex()

    override suspend fun getRental(rentalId: String): Rental? = mutex.withLock {
        rentals[rentalId]
    }

    override suspend fun saveRental(rental: Rental) = mutex.withLock {
        rentals[rental.rentalId] = rental
    }
}
