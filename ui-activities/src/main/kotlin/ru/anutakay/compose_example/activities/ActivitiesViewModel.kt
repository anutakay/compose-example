package ru.anutakay.compose_example.activities

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.anutakay.compose_example.data.entities.Activity
import ru.anutakay.compose_example.data.entities.DayActivities
import ru.anutakay.compose_example.domain.usecases.GetActivitiesByDate
import ru.anutakay.compose_example.domain.usecases.GetActivitiesUseCase
import javax.inject.Inject

@HiltViewModel
internal class ActivitiesViewModel @Inject constructor(
    getActivities: GetActivitiesUseCase,
    getActivitiesGroupedByDay: GetActivitiesByDate
) : ViewModel() {
    val activities: List<Activity> = getActivities.execute()
    val groupedActivities: List<DayActivities> = getActivitiesGroupedByDay.execute()
}
