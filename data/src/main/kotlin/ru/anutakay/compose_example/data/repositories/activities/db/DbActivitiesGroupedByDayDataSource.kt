package ru.anutakay.compose_example.data.repositories.activities.db

import io.reactivex.rxjava3.core.Observable
import ru.anutakay.compose_example.data.ExampleDatabase
import ru.anutakay.compose_example.data.repositories.activities.ActivitiesGroupedByDayDataSource
import ru.anutakay.compose_example.model.entities.Activity
import ru.anutakay.compose_example.model.entities.DayActivities
import java.time.LocalDateTime
import java.time.Month
import javax.inject.Inject

class DbActivitiesGroupedByDayDataSource @Inject constructor(
    private val database: ExampleDatabase
) : ActivitiesGroupedByDayDataSource {

    private val dateTime: LocalDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40)
    private val list = mutableListOf(
        Activity("first action 111", dateTime),
        Activity("second action", dateTime.plusDays(2)),
        Activity("action", dateTime.plusHours(2))
    )

    override fun observeActivitiesGroupedByDay(): Observable<List<DayActivities>> =
        Observable.just(database.activitiesDao().getActivities())
            .map {
                list.map {
                    Activity("first action 111", dateTime)
                }
            }
            .map { list ->
                list.groupBy { it.dateTime.toLocalDate() }
                    .map { DayActivities(it.key, it.value) }
                    .sortedByDescending { it.date }
            }
}
