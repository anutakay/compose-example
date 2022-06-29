package ru.anutakay.compose_example.data.repositories.activities

import ru.anutakay.compose_example.data.entities.Activity
import ru.anutakay.compose_example.data.entities.DayActivities
import javax.inject.Inject

class ActivitiesRepository @Inject constructor(
    private val activitiesFeedDataSource: ActivitiesFeedDataSource,
    private val activitiesGroupedByDayDataSource: ActivitiesGroupedByDayDataSource
) {
    fun getActivities(): List<Activity> = activitiesFeedDataSource.getActivities()

    fun activitiesGroupedByDay(): List<DayActivities> =
        activitiesGroupedByDayDataSource.getActivitiesGroupedByDay()
}
