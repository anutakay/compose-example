package ru.anutakay.compose_example.data.repositories.activities

import ru.anutakay.compose_example.model.entities.Activity
import javax.inject.Inject
import ru.anutakay.compose_example.data.repositories.activities.interfaces.ActivitiesGroupedByDayDataSource
import ru.anutakay.compose_example.data.repositories.activities.interfaces.AddActivityGateway
import ru.anutakay.compose_example.data.repositories.activities.interfaces.AddEmotionNoteGateway
import ru.anutakay.compose_example.data.repositories.activities.interfaces.EmotionOptionsDataSource
import ru.anutakay.compose_example.model.entities.EmotionNote

class ActivitiesRepository @Inject constructor(
    private val activitiesGroupedByDay: ActivitiesGroupedByDayDataSource,
    private val addActivity: AddActivityGateway,
    private val emotionOptions: EmotionOptionsDataSource,
    private val addEmotionNote: AddEmotionNoteGateway
) {
    fun observeActivitiesGroupedByDay() =
        activitiesGroupedByDay.observeActivitiesGroupedByDay()

    fun addActivity(activity: Activity) = addActivity.addActivity(activity)

    fun observeEmotionOptions() = emotionOptions.observeEmotionOptions()

    fun addEmotionNote(note: EmotionNote) = addEmotionNote.addEmotionNote(note)
}
