package ru.anutakay.compose_example.domain.observers

import ru.anutakay.compose_example.model.entities.DayActivities
import ru.anutakay.compose_example.data.repositories.activities.ActivitiesRepository
import javax.inject.Inject
import ru.anutakay.compose_example.base.usecases.SimpleObserver

class ObserveActivitiesByDate @Inject constructor(
    private val repository: ActivitiesRepository
): SimpleObserver<List<DayActivities>>() {
    override fun createObservable() = repository.observeActivitiesGroupedByDay()
}
