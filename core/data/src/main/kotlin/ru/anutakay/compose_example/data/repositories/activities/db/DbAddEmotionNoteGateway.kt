package ru.anutakay.compose_example.data.repositories.activities.db

import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject
import ru.anutakay.compose_example.data.ExampleDatabase
import ru.anutakay.compose_example.data.ExampleTypeConverters
import ru.anutakay.compose_example.data.repositories.activities.interfaces.AddEmotionNoteGateway
import ru.anutakay.compose_example.model.entities.EmotionNote

class DbAddEmotionNoteGateway @Inject constructor(
    private val database: ExampleDatabase
) : AddEmotionNoteGateway {

    override fun addEmotionNote(activity: EmotionNote): Completable =
        Completable.fromAction {
            activity.let(ExampleTypeConverters::toDbEntity)
                .also(database.emotionsDao()::addEmotionsNote)
        }
}
