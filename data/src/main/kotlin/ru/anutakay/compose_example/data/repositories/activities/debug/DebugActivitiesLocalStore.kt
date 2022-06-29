package ru.anutakay.compose_example.data.repositories.activities.debug

import ru.anutakay.compose_example.data.entities.Activity
import java.time.LocalDateTime
import java.time.Month
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DebugActivitiesLocalStore @Inject constructor() {

    val activities: List<Activity>
        get() {
            val dateTime: LocalDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40)
            return listOf(
                Activity("first", dateTime),
                Activity("second", dateTime.plusDays(2)),
                Activity("cat", dateTime.plusHours(2))
            )
        }
}
