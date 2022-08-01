package ru.anutakay.compose_example.add_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.launch
import ru.anutakay.compose_example.model.entities.Activity
import ru.anutakay.compose_example.domain.usecases.AddActivityInteractor
import javax.inject.Inject

@HiltViewModel
class AddActivityViewModel @Inject constructor(
    val addActivity: AddActivityInteractor
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun addActivity(activity: Activity) {
        viewModelScope.launch {
            addActivity(AddActivityInteractor.Params(activity))
                .subscribe()
                .track()
        }
    }

    private fun Disposable.track() {
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
