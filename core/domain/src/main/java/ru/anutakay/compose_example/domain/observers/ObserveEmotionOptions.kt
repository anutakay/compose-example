package ru.anutakay.compose_example.domain.observers

import javax.inject.Inject
import ru.anutakay.compose_example.base.usecases.SimpleObserver
import ru.anutakay.compose_example.data.repositories.activities.ActivitiesRepository
import ru.anutakay.compose_example.model.entities.Emotion

class ObserveEmotionOptions @Inject constructor(
    private val repository: ActivitiesRepository
): SimpleObserver<List<Pair<String, Emotion>>>() {
    override fun createObservable() = repository.observeEmotionOptions()
}
