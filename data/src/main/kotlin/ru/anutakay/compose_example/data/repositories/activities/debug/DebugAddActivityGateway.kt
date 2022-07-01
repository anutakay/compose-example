package ru.anutakay.compose_example.data.repositories.activities.debug

import io.reactivex.rxjava3.core.Completable
import ru.anutakay.compose_example.data.entities.Activity
import ru.anutakay.compose_example.data.repositories.activities.AddActivityGateway
import javax.inject.Inject

class DebugAddActivityGateway @Inject constructor(
    private val store: DebugActivitiesLocalStore
) : AddActivityGateway {
    override fun addActivity(activity: Activity): Completable =
        Completable.fromAction { store.addActivity(activity) }
}