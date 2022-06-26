package ru.anutakay.compose_example.data.repositories.activities

interface ActivitiesFeedDataSource {
    fun getActivities(): List<String>
}
