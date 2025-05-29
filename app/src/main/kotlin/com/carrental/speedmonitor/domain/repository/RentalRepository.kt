package com.carrental.speedmonitor.domain.repository

import com.carrental.speedmonitor.domain.model.Rental

interface RentalRepository {
    suspend fun getRental(rentalId: String): Rental?
    suspend fun saveRental(rental: Rental)
}
