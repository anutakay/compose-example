package ru.anutakay.compose_example.add_activity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.anutakay.compose_example.model.entities.Activity
import ru.anutakay.compose_example.domain.interactors.AddActivityInteractor
import javax.inject.Inject

@HiltViewModel
class AddActivityViewModel @Inject constructor(
    private val addActivity: AddActivityInteractor
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun addActivity(activity: Activity) =
        addActivity(AddActivityInteractor.Params(activity))
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
