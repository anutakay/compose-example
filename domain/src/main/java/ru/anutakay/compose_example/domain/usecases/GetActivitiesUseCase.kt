package ru.anutakay.compose_example.domain.usecases

import ru.anutakay.compose_example.data.entities.Activity
import ru.anutakay.compose_example.data.repositories.activities.ActivitiesRepository
import javax.inject.Inject

class GetActivitiesUseCase @Inject constructor(
    private val repository: ActivitiesRepository
) {
    fun execute(): List<Activity> = repository.getActivities()
}
