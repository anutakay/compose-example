package ru.anutakay.compose_example.domain.interactors

import javax.inject.Inject
import ru.anutakay.compose_example.base.usecases.Interactor
import ru.anutakay.compose_example.data.repositories.activities.ActivitiesRepository
import ru.anutakay.compose_example.model.entities.EmotionNote

class AddEmotionNoteInteractor @Inject constructor(
    private val repository: ActivitiesRepository
) : Interactor<AddEmotionNoteInteractor.Params>() {

    override fun doWork(params: Params) = repository.addEmotionNote(params.emotionNote)

    data class Params(
        val emotionNote: EmotionNote
    )
}
