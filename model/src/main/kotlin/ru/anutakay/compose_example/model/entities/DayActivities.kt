package ru.anutakay.compose_example.model.entities

import java.time.LocalDate

data class DayActivities(
    val date: LocalDate,
    val activities: List<Activity>
)
