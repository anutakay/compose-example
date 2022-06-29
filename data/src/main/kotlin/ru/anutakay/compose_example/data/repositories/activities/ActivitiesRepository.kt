package ru.anutakay.compose_example.data.repositories.activities

import javax.inject.Inject

class ActivitiesRepository @Inject constructor(
    private val activitiesFeedDataSource: ActivitiesFeedDataSource
) {
    fun getActivities() = activitiesFeedDataSource.getActivities()
}
