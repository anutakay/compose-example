package ru.anutakay.compose_example.data.repositories.activities.generate

import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import ru.anutakay.compose_example.data.repositories.activities.interfaces.EmotionOptionsDataSource
import ru.anutakay.compose_example.model.entities.Emotion

class GenerateEmotionOptionsDataSource @Inject constructor(): EmotionOptionsDataSource {

    override fun observeEmotionOptions(): Observable<List<Pair<String, Emotion>>> = listOf(
        Pair("Interests", Emotion.INTERESTS),
        Pair("Enjoyment", Emotion.ENJOYMENT),
        Pair("Surprise", Emotion.SURPRISE),
        Pair("Distress", Emotion.DISTRESS),
        Pair("Fear", Emotion.FEAR),
        Pair("Anger", Emotion.ANGER),
        Pair("Shame", Emotion.SHAME),
        Pair("Disgust", Emotion.DISGUST)
     ).let { Observable.just(it) }
}
