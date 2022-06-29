package ru.anutakay.compose_example.data.repositories.activities.debug

import ru.anutakay.compose_example.data.repositories.activities.ActivitiesFeedDataSource
import javax.inject.Inject

class DebugActivitiesFeedDataSource @Inject constructor(
    private val store: DebugActivitiesLocalStore
) : ActivitiesFeedDataSource {
    override fun getActivities() = store.activities
}
