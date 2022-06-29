package ru.anutakay.compose_example.data.repositories.activities

import ru.anutakay.compose_example.data.entities.DayActivities

interface ActivitiesGroupedByDayDataSource {
    fun getActivitiesGroupedByDay(): List<DayActivities>
}
