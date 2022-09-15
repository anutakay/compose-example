package ru.anutakay.compose_example.activities

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.anutakay.compose_example.domain.observers.ObserveActivitiesByDate
import javax.inject.Inject
import ru.anutakay.compose_example.model.entities.DayActivities

@HiltViewModel
class ActivitiesViewModel @Inject constructor(
    getActivitiesGroupedByDay: ObserveActivitiesByDate
) : ViewModel() {
    val groupedActivities: Observable<List<DayActivities>> =
        getActivitiesGroupedByDay
            .observable
            .subscribeOn(Schedulers.io())
}
