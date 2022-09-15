package ru.anutakay.compose_example.add_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch
import ru.anutakay.compose_example.model.entities.Activity
import ru.anutakay.compose_example.domain.interactors.AddActivityInteractor
import javax.inject.Inject

@HiltViewModel
class AddActivityViewModel @Inject constructor(
    val addActivity: AddActivityInteractor
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun addActivity(activity: Activity) {
        addActivity(AddActivityInteractor.Params(activity))
            .subscribeOn(Schedulers.io())
            .subscribe()
            .track()
    }

    private fun Disposable.track() {
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
