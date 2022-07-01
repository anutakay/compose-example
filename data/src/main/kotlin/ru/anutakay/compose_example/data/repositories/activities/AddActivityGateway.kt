package ru.anutakay.compose_example.data.repositories.activities

import io.reactivex.rxjava3.core.Completable
import ru.anutakay.compose_example.data.entities.Activity

interface AddActivityGateway {
    fun addActivity(activity: Activity): Completable
}
