package ru.anutakay.compose_example.data.repositories.activities.debug

import io.reactivex.rxjava3.core.Observable
import ru.anutakay.compose_example.data.entities.Activity
import java.time.LocalDateTime
import java.time.Month
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DebugActivitiesLocalStore @Inject constructor() {

    val activities: Observable<List<Activity>>
        get() {
            val dateTime: LocalDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40)
            return listOf(
                Activity("first action", dateTime),
                Activity("second action", dateTime.plusDays(2)),
                Activity("action", dateTime.plusHours(2))
            ).let { Observable.just(it) }
        }
}
