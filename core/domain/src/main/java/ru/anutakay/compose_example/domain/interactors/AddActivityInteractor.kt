package ru.anutakay.compose_example.domain.interactors

import ru.anutakay.compose_example.model.entities.Activity
import ru.anutakay.compose_example.data.repositories.activities.ActivitiesRepository
import ru.anutakay.compose_example.base.usecases.Interactor
import javax.inject.Inject

class AddActivityInteractor @Inject constructor(
    private val repository: ActivitiesRepository
) : Interactor<AddActivityInteractor.Params>() {

    override fun doWork(params: Params) = repository.addActivity(params.activity)

    data class Params(
        val activity: Activity
    )
}
