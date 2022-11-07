package ru.anutakay.compose_example.data.repositories.activities.db

import io.reactivex.rxjava3.core.Completable
import ru.anutakay.compose_example.model.entities.Activity
import ru.anutakay.compose_example.data.repositories.activities.interfaces.AddActivityGateway
import javax.inject.Inject
import ru.anutakay.compose_example.data.ExampleDatabase
import ru.anutakay.compose_example.data.ExampleTypeConverters.toDbEntity

class DbAddActivityGateway @Inject constructor(
    private val database: ExampleDatabase
) : AddActivityGateway {
    override fun addActivity(activity: Activity): Completable =
        Completable.fromAction {
            activity.let(::toDbEntity)
                .also(database.activitiesDao()::addActivityNote)
        }
}