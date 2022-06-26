package ru.anutakay.compose_example.activities

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.anutakay.compose_example.domain.usecases.GetActivitiesUseCase
import javax.inject.Inject

@HiltViewModel
internal class ActivitiesViewModel @Inject constructor(
    getActivities: GetActivitiesUseCase
) : ViewModel() {

    init {
        val activities = getActivities.execute()
        println("ActivitiesViewModel")
        println("activities $activities")
    }
}