package ru.anutakay.compose_example.data.repositories.activities.interfaces

import io.reactivex.rxjava3.core.Completable
import ru.anutakay.compose_example.model.entities.Activity

interface AddActivityGateway {
    fun addActivity(activity: Activity): Completable
}
