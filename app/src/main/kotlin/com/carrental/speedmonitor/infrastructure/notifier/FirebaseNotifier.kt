package com.carrental.speedmonitor.infrastructure.notifier

import com.carrental.speedmonitor.domain.model.Rental
import com.carrental.speedmonitor.domain.model.SpeedEvent
import kotlinx.coroutines.delay
import kotlin.random.Random

class FirebaseNotifier : Notifier {
    override suspend fun notifyRentalCompany(rental: Rental, event: SpeedEvent): Boolean {
        delay(100)
        val success = Random.nextInt(0, 10) > 1 // 90% success rate
        println(if(success) "Firebase notified rental company." else "Firebase notify failed.")
        return success
    }

    override suspend fun alertUser(userId: String, message: String): Boolean {
        delay(100)
        val success = Random.nextInt(0, 10) > 1
        println(if(success) "Firebase alerted user." else "Firebase alert failed.")
        return success
    }
}
