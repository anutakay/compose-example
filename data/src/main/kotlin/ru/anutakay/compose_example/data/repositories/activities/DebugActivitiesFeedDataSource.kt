package ru.anutakay.compose_example.data.repositories.activities

import ru.anutakay.compose_example.data.entities.Activity
import javax.inject.Inject

class DebugActivitiesFeedDataSource @Inject constructor() : ActivitiesFeedDataSource {

    override fun getActivities(): List<Activity> = listOf(
        Activity("first", 1656494376),
        Activity("second", 1655518776),
        Activity("cat", 1655043276)
    )
}
