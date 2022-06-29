package ru.anutakay.compose_example.data.repositories.activities.debug

import ru.anutakay.compose_example.data.entities.Activity
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneId
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DebugActivitiesLocalStore @Inject constructor() {

    val activities: List<Activity>
        get() {
            val dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40)
            return listOf(
                Activity("first", getTimestamp(dateTime)),
                Activity("second", getTimestamp(dateTime.plusDays(2))),
                Activity("cat", getTimestamp(dateTime.plusHours(2)))
            )
        }

    private fun getTimestamp(dateTime: LocalDateTime) =
        dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}
