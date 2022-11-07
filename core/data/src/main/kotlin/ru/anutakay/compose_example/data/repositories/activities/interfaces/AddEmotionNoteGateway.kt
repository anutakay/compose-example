package ru.anutakay.compose_example.data.repositories.activities.interfaces

import io.reactivex.rxjava3.core.Completable
import ru.anutakay.compose_example.model.entities.EmotionNote

interface AddEmotionNoteGateway {
    fun addEmotionNote(activity: EmotionNote): Completable
}
