package ru.anutakay.compose_example.domain.usecases

import ru.anutakay.compose_example.data.repositories.activities.ActivitiesRepository
import javax.inject.Inject

class GetActivitiesByDate @Inject constructor(
    private val repository: ActivitiesRepository
) {
    fun execute() = repository.activitiesGroupedByDay()
}
