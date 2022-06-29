package ru.anutakay.compose_example.data.entities

import java.time.LocalDate

data class DayActivities(
    val date: LocalDate,
    val activities: List<Activity>
)
