package ru.anutakay.compose_example.data.repositories.activities

import io.reactivex.rxjava3.core.Observable
import ru.anutakay.compose_example.data.entities.DayActivities
import javax.inject.Inject

class ActivitiesRepository @Inject constructor(
    private val activitiesGroupedByDayDataSource: ActivitiesGroupedByDayDataSource
) {
    fun observeActivitiesGroupedByDay(): Observable<List<DayActivities>> =
        activitiesGroupedByDayDataSource.observeActivitiesGroupedByDay()
}
