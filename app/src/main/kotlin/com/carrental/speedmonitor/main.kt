package com.carrental.speedmonitor

import com.carrental.speedmonitor.data.repository.InMemoryRentalRepository
import com.carrental.speedmonitor.domain.model.Rental
import com.carrental.speedmonitor.domain.model.SpeedEvent
import com.carrental.speedmonitor.domain.usecase.ProcessSpeedEventUseCase
import com.carrental.speedmonitor.infrastructure.notifier.AwsNotifier
import com.carrental.speedmonitor.infrastructure.notifier.ChainedNotifier
import com.carrental.speedmonitor.infrastructure.notifier.FirebaseNotifier
import com.carrental.speedmonitor.presentation.viewmodel.SpeedMonitorViewModel
import kotlinx.coroutines.*

suspend fun setupSampleData(repository: InMemoryRentalRepository) {
    repository.saveRental(Rental("r1", "user1", "carA", 80.0))
    repository.saveRental(Rental("r2", "user2", "carB", 100.0))
}

fun main() = runBlocking {
    val rentalRepo = InMemoryRentalRepository()
    setupSampleData(rentalRepo)

    val firebaseNotifier = FirebaseNotifier()
    val awsNotifier = AwsNotifier()
    val notifier = ChainedNotifier(firebaseNotifier, awsNotifier)

    val useCase = ProcessSpeedEventUseCase(rentalRepo, notifier)
    val viewModel = SpeedMonitorViewModel(useCase)

    val testEvents = listOf(
        SpeedEvent("r1", System.currentTimeMillis(), 85.0),  // Over speed
        SpeedEvent("r1", System.currentTimeMillis(), 70.0),  // Within speed
        SpeedEvent("r2", System.currentTimeMillis(), 110.0), // Over speed
        SpeedEvent("r3", System.currentTimeMillis(), 120.0)  // Rental doesn't exist
    )

    coroutineScope {
        testEvents.forEach { event ->
            launch {
                viewModel.onSpeedEvent(event)
            }
        }
    }
}
