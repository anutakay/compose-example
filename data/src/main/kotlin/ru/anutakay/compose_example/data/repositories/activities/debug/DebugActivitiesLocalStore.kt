package ru.anutakay.compose_example.data.repositories.activities.debug

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import ru.anutakay.compose_example.model.entities.Activity
import java.time.LocalDateTime
import java.time.Month
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DebugActivitiesLocalStore @Inject constructor() {

    private val dateTime: LocalDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40)
    private val list = mutableListOf(
        Activity("first action", dateTime),
        Activity("second action", dateTime.plusDays(2)),
        Activity("action", dateTime.plusHours(2))
    )

    private val activitiesProcessor: BehaviorProcessor<List<Activity>> =
        BehaviorProcessor.createDefault(list)

    val activities: Observable<List<Activity>> = activitiesProcessor.toObservable()

    fun addActivity(activity: Activity) {
        activitiesProcessor.onNext(list.apply { add(activity) })
    }
}
