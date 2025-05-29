package com.carrental.speedmonitor.infrastructure.notifier

import com.carrental.speedmonitor.domain.model.Rental
import com.carrental.speedmonitor.domain.model.SpeedEvent
import kotlinx.coroutines.delay
import kotlin.random.Random

class AwsNotifier : Notifier {
    override suspend fun notifyRentalCompany(rental: Rental, event: SpeedEvent): Boolean {
        delay(100)
        val success = Random.nextInt(0, 10) > 2 // 80% success rate
        println(if(success) "AWS notified rental company." else "AWS notify failed.")
        return success
    }

    override suspend fun alertUser(userId: String, message: String): Boolean {
        delay(100)
        val success = Random.nextInt(0, 10) > 2
        println(if(success) "AWS alerted user." else "AWS alert failed.")
        return success
    }
}
