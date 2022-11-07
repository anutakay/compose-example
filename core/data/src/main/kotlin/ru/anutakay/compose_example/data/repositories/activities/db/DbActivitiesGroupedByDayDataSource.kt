package ru.anutakay.compose_example.data.repositories.activities.db

import io.reactivex.rxjava3.core.Observable
import ru.anutakay.compose_example.data.ExampleDatabase
import ru.anutakay.compose_example.data.repositories.activities.interfaces.ActivitiesGroupedByDayDataSource
import ru.anutakay.compose_example.model.entities.DayActivities
import javax.inject.Inject
import ru.anutakay.compose_example.data.ExampleTypeConverters.toModelEntity
import ru.anutakay.compose_example.model.entities.Activity

class DbActivitiesGroupedByDayDataSource @Inject constructor(
    private val database: ExampleDatabase
) : ActivitiesGroupedByDayDataSource {

    override fun observeActivitiesGroupedByDay(): Observable<List<DayActivities>> =
        Observable.combineLatest(
            database.activitiesDao().getActivities()
                .map { it.map(::toModelEntity) },
            database.emotionsDao().getEmotionNotes()
                .map {
                    it.map(::toModelEntity)
                        .map { item -> Activity(
                            title = item.emotion.name,
                            dateTime = item.dateTime
                        ) }
                }
        ) { a, b -> a + b }
            .map { list ->
                list.groupBy { it.dateTime.toLocalDate() }
                    .map { DayActivities(it.key, it.value) }
                    .sortedByDescending { it.date }
            }
}
