package ru.anutakay.compose_example.data.repositories.activities.interfaces

import io.reactivex.rxjava3.core.Observable
import ru.anutakay.compose_example.model.entities.Emotion

interface EmotionOptionsDataSource {
    fun observeEmotionOptions(): Observable<List<Pair<String, Emotion>>>
}
