package ru.anutakay.compose_example.data.repositories.activities.debug

import ru.anutakay.compose_example.data.entities.DayActivities
import ru.anutakay.compose_example.data.repositories.activities.ActivitiesGroupedByDayDataSource
import javax.inject.Inject

class DebugActivitiesGroupedByDayDataSource @Inject constructor(
    private val store: DebugActivitiesLocalStore
) : ActivitiesGroupedByDayDataSource {
    override fun getActivitiesGroupedByDay(): List<DayActivities> =
        store.activities
            .groupBy { it.timestamp }
            .map { DayActivities(it.key, it.value) }
}
