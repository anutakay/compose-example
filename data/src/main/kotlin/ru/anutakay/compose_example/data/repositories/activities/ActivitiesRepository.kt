package ru.anutakay.compose_example.data.repositories.activities

import ru.anutakay.compose_example.model.entities.Activity
import javax.inject.Inject

class ActivitiesRepository @Inject constructor(
    private val activitiesGroupedByDay: ActivitiesGroupedByDayDataSource,
    private val addActivity: AddActivityGateway
) {
    fun observeActivitiesGroupedByDay() =
        activitiesGroupedByDay.observeActivitiesGroupedByDay()

    fun addActivity(activity: Activity) = addActivity.addActivity(activity)
}
