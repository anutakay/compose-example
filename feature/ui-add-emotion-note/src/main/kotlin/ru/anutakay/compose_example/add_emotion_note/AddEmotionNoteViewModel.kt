package ru.anutakay.compose_example.add_emotion_note

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import ru.anutakay.compose_example.domain.interactors.AddEmotionNoteInteractor
import ru.anutakay.compose_example.domain.observers.ObserveEmotionOptions
import ru.anutakay.compose_example.model.entities.Emotion
import ru.anutakay.compose_example.model.entities.EmotionNote

@HiltViewModel
class AddEmotionNoteViewModel @Inject constructor(
    observeEmotionOptions: ObserveEmotionOptions,
    private val addEmotionNote: AddEmotionNoteInteractor
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val emotionOptions: Observable<List<Pair<String, Emotion>>> =
        observeEmotionOptions
            .observable
            .subscribeOn(Schedulers.io())

    fun addEmotionsNote(note: EmotionNote) =
        addEmotionNote(AddEmotionNoteInteractor.Params(note))
            .subscribeOn(Schedulers.io())
            .subscribe()
            .track()

    private fun Disposable.track() {
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
