package ru.anutakay.compose_example.domain.usecases

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import ru.anutakay.compose_example.data.entities.DayActivities
import ru.anutakay.compose_example.data.repositories.activities.ActivitiesRepository
import javax.inject.Inject

class ObserveActivitiesByDate @Inject constructor(
    private val repository: ActivitiesRepository
) {
    private val params = BehaviorSubject.create<Unit>()

    val observable: Observable<List<DayActivities>> =
        params
            .flatMap { createObservable() }
            .distinctUntilChanged()

    operator fun invoke() = params.onNext(Unit)

    private fun createObservable() = repository.observeActivitiesGroupedByDay()
}
