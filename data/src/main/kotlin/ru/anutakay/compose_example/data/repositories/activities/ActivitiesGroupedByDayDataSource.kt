package ru.anutakay.compose_example.data.repositories.activities

import io.reactivex.rxjava3.core.Observable
import ru.anutakay.compose_example.data.entities.DayActivities

interface ActivitiesGroupedByDayDataSource {
    fun observeActivitiesGroupedByDay(): Observable<List<DayActivities>>
}
