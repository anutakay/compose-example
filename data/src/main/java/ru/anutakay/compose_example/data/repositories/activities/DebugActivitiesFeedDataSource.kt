package ru.anutakay.compose_example.data.repositories.activities

import javax.inject.Inject

class DebugActivitiesFeedDataSource @Inject constructor() : ActivitiesFeedDataSource {

    override fun getActivities(): List<String> = listOf("first, second, cat")
}
