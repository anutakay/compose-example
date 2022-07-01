package ru.anutakay.compose_example.data.repositories.activities.debug

import io.reactivex.rxjava3.core.Observable
import ru.anutakay.compose_example.data.entities.DayActivities
import ru.anutakay.compose_example.data.repositories.activities.ActivitiesGroupedByDayDataSource
import javax.inject.Inject

class DebugActivitiesGroupedByDayDataSource @Inject constructor(
    private val store: DebugActivitiesLocalStore
) : ActivitiesGroupedByDayDataSource {
    override fun observeActivitiesGroupedByDay(): Observable<List<DayActivities>> =
        store.activities
            .map { list ->
                list.groupBy { it.dateTime.toLocalDate() }
                    .map { DayActivities(it.key, it.value) }
                    .sortedByDescending { it.date }
            }
}
