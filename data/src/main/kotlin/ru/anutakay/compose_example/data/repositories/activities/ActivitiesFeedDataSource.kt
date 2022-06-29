package ru.anutakay.compose_example.data.repositories.activities

import ru.anutakay.compose_example.data.entities.Activity

interface ActivitiesFeedDataSource {
    fun getActivities(): List<Activity>
}
