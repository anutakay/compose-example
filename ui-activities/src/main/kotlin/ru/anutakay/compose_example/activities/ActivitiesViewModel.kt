package ru.anutakay.compose_example.activities

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.anutakay.compose_example.domain.usecases.ObserveActivitiesByDate
import javax.inject.Inject

@HiltViewModel
internal class ActivitiesViewModel @Inject constructor(
    getActivitiesGroupedByDay: ObserveActivitiesByDate
) : ViewModel() {
    val groupedActivities = getActivitiesGroupedByDay.observable

    init {
        getActivitiesGroupedByDay()
    }
}
